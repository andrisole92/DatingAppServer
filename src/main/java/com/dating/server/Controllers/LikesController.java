package com.dating.server.Controllers;

import com.dating.server.Authentication.MyUserPrincipal;
import com.dating.server.Xmpp.DataJpa.XmppUser;
import com.dating.server.Xmpp.DataJpa.XmppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dating.server.JPA.LikeRepository;
import com.dating.server.Features.likes.LikesFeature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("like")
public class LikesController {

    private final
    LikeRepository likeRepository;

    @Autowired
    XmppUserRepository userRepository;

    public LikesController(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Likes Feature";
    }


    @RequestMapping(value = "/like", method = RequestMethod.POST)
    @ResponseBody
    public Object like(
            @RequestParam() String uid2,
            @RequestParam(defaultValue = "false") boolean like,
            HttpSession httpSession
    ) {
        MyUserPrincipal principal = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XmppUser user = principal.getUser();
        String uid1 = user.getUsername();
        likeRepository.save(LikesFeature.LikeFactory.createLike(uid1, uid2, like));
        boolean e = likeRepository.exists(Example.of(LikesFeature.LikeFactory.createLike(uid2, uid1, like)));
        if (e) {
            return new MatchResponse(true, userRepository.findByUsername(uid2));
        } else {
            return new LikeResponse(false, uid2);
        }
    }

}

@Getter
@Setter
@AllArgsConstructor
class LikeResponse {
    boolean matched;
    String uid;
}


@Getter
@Setter
@AllArgsConstructor
class MatchResponse {
    boolean matched;
    XmppUser user;
}