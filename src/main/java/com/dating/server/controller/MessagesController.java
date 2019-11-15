package com.dating.server.controller;


import com.dating.server.model.Channel;
import com.dating.server.payload.ApiResponse;
import com.dating.server.payload.SendMessageRequest;
import com.dating.server.repository.ChannelRepository;
import com.dating.server.model.Message;
import com.dating.server.repository.MessagesRepository;
import com.dating.server.repository.UserRepository;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;

@Tag(name = "Messages")
@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping(name = "message", consumes = {"application/json"}, produces = {"application/json"})
@CommonsLog(topic = "MessagesController")
public class MessagesController {
    @Autowired
    MessagesRepository messagesRepository;

    @Autowired
    UserRepository userRepository;


    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Messages Controller!";
    }


    @PostMapping(value = "/send")
    @PreAuthorize("hasRole('USER')")
    @Transactional
    public ResponseEntity<?> send_message(
            @Valid @RequestBody SendMessageRequest sendMessageRequest,
            @AuthenticationPrincipal Principal p
    ) {
        log.info("send_message: " + sendMessageRequest.toString());
        String body = sendMessageRequest.getBody();
        Long channelId = sendMessageRequest.getChannelId();
        Channel channel = channelRepository.getOne(channelId);
        log.info(channel.toString());
        if (channel.getUsers().contains(userRepository.getOne(p.getName()))) {
            log.info("User is participant of the channel");
        } else {
            log.info("User is not in the channel");
        }
        Message message = new Message(userRepository.getOne(p.getName()), body, channel);
        messagesRepository.save(message);

//        this.template.convertAndSendToUser(p.getName(), "/channel/reply", message.toString());
        this.template.convertAndSend("/channel/" + channelId, message.toString());



        return ResponseEntity.ok().body(new ApiResponse(true, "Sent"));
    }
}