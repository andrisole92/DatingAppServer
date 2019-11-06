package com.dating.server.controller;

import com.dating.server.model.Channel;
import com.dating.server.model.Like;
import com.dating.server.model.Match;
import com.dating.server.payload.ApiResponse;
import com.dating.server.payload.LikeRequest;
import com.dating.server.payload.LikeResponse;
import com.dating.server.repository.MatchRepository;
import com.dating.server.repository.UserRepository;
import com.dating.server.security.UserPrincipal;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;

import com.dating.server.repository.LikeRepository;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("like")
@CommonsLog(topic = "LikesController")
public class LikeController {

    private final
    LikeRepository likeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MatchRepository matchRepository;

    public LikeController(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @RequestMapping("/")
    @PreAuthorize("hasRole('USER')")
    public UserPrincipal index(Authentication authentication) {
        log.info(authentication.getPrincipal().toString());
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info(userPrincipal.toString());
        return userPrincipal;
    }


    @RequestMapping(value = "/like", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> like(
            @Valid @RequestBody LikeRequest likeRequest,
            @AuthenticationPrincipal Principal principal
    ) {

        String senderUsername = principal.getName();
        String likedUsername = likeRequest.getLikedUsername();
        boolean isLike = likeRequest.isLike();
        log.info("senderUsername: "+senderUsername);
        log.info("likedUsername: "+likedUsername);
        Like l = likeRepository.save(new Like(senderUsername, likedUsername, isLike));

        boolean e = likeRepository.exists(Example.of(new Like(likedUsername, senderUsername, isLike)));
        log.info("Match: "+e);
        if (e) {
            try{
                log.info("Creating the channel");
                Channel channel = new Channel();
                channel.getUsers().add(userRepository.getOne(senderUsername));
                channel.getUsers().add(userRepository.getOne(likedUsername));
                log.info("Channel created: "+channel.toString());
//                UserChannel userChannel1 = new UserChannel(userRepository.getOne(senderUsername), channel);
//                UserChannel userChannel2 = new UserChannel(userRepository.getOne(likedUsername), channel);
//                log.info("UserChannel created: "+userChannel1.toString());
//                HashSet<UserChannel> hashSet = new HashSet<UserChannel>();
//                hashSet.add(userChannel1);
//                channel.setUserChannels(hashSet);
//                channel.getUserChannels().add(new UserChannel(userRepository.getOne(senderUsername), channel));
//                channel.getUserChannels().add(new UserChannel(userRepository.getOne(likedUsername), channel));
//                log.info(channel.toString());
                Match m = matchRepository.save(new Match(senderUsername, likedUsername, channel));
                log.info(m.toString());
                return ResponseEntity.ok().body(new LikeResponse(true));
            } catch (Exception exc){
                exc.printStackTrace();
                return ResponseEntity.ok().body(new ApiResponse(false, exc.getMessage()));
            }


//            Optional<User> user = userRepository.findByUsername(likedUsername);
//            if (user.isPresent()){
//                return ResponseEntity.ok().body(new MatchResponse(true, user.get()));
//            } else {
//                return ResponseEntity.ok().body(new ApiResponse(false,"Can't find second user :) Sorry!"));
//            }
        } else {
            return ResponseEntity.ok().body(new ApiResponse(true, "Liked"));
        }
    }

}
//
//@Getter
//@Setter
//@AllArgsConstructor
//class LikeResponse {
//    boolean matched;
//    String uid;
//}

//
//@Getter
//@Setter
//@AllArgsConstructor
//class MatchResponse {
//    boolean matched;
//    String usernm;
//}