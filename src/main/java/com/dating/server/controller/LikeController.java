package com.dating.server.controller;

import com.dating.server.model.Channel;
import com.dating.server.model.Like;
import com.dating.server.model.Match;
import com.dating.server.payload.response.ApiResponse;
import com.dating.server.payload.request.LikeRequest;
import com.dating.server.payload.response.LikeResponse;
import com.dating.server.repository.MatchRepository;
import com.dating.server.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.dating.server.repository.LikeRepository;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;

@Tag(name = "Like")
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

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> like(
            @PathVariable String userId,
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
                Match m = matchRepository.save(new Match(senderUsername, likedUsername, channel));
                log.info(m.toString());
                return ResponseEntity.ok().body(new LikeResponse(true));
            } catch (Exception exc){
                exc.printStackTrace();
                return ResponseEntity.ok().body(new ApiResponse(false, exc.getMessage()));
            }

        } else {
            return ResponseEntity.ok().body(new ApiResponse(true, "Liked"));
        }
    }

}
