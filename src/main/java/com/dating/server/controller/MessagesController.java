package com.dating.server.controller;


import com.dating.server.model.Channel;
import com.dating.server.payload.ApiResponse;
import com.dating.server.repository.ChannelRepository;
import com.dating.server.model.Message;
import com.dating.server.repository.MessagesRepository;
import com.dating.server.security.UserPrincipal;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("messages")
@CommonsLog(topic = "MessagesController")
public class MessagesController {
//
//    @Autowired
//    XmppAdmin xmppAdmin;

    @Autowired
    MessagesRepository messagesRepository;


    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Messages Controller!";
    }

//    @RequestMapping(value = "/send", method = RequestMethod.POST)
//    @ResponseBody
//    public Object send(
//            @RequestParam(defaultValue = "") String to,
//            @RequestParam(defaultValue = "") String subject,
//            @RequestParam(defaultValue = "") String body,
//            @RequestParam(defaultValue = "") String type,
//            HttpSession httpSession
//    ) {
//        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        XmppUser user = principal.getUser();
//        String from = user.getUsername();
//        String username = ((UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//        this.template.convertAndSendToUser(username, "/queue/reply", "message");
//
////        this.template.convertAndSend("/topic/greetings", new HelloMessage("Hello"));
//        return true;
////        try {
////            xmppAdmin.sendMessage("", from, to, subject, body);
////            return true;
////        } catch (Exception e) {
////            e.printStackTrace();
////            return e.getMessage();
////        }
//    }

//    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
//    @ResponseBody
//    public Object sendMessage(
//            @RequestParam(defaultValue = "") String body,
//            @RequestParam(defaultValue = "") Long channelId,
//            @RequestParam(defaultValue = "") String type,
//            HttpSession httpSession
//    ) {
//        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        XmppUser user = principal.getUser();
//        String username = user.getUsername();
//        Optional<Channel> c = channelRepository.findById(channelId);
////        c.ifPresent(channel -> messagesRepository.save(new Message(username, body, channel)));
//
//        this.template.convertAndSendToUser(username, "/queue/reply", "message");
//
//        this.template.convertAndSend("/channel/3", "Buuuu");
//        this.template.convertAndSend("/3", "Buuuu");
//        return true;
//    }


    @RequestMapping(value = "/send_message", method = RequestMethod.POST)
    @ResponseBody
    public Object send_message(
            @RequestParam(defaultValue = "Hello World!") String body,
            @RequestParam(defaultValue = "1") Long channelId,
            HttpSession httpSession,
            @AuthenticationPrincipal Principal p,
            Authentication authentication
    ) {
        try {
            UserPrincipal principal = (UserPrincipal)authentication.getPrincipal();
            log.info(principal.toString());
            log.info(p.getName());
        } catch (Exception e) {
            log.error("Cant get user principal");
        }

//        XmppUser user = principal.getUser();
//        log.info(user.toString());
//
//        String username = principal.();
//        log.info("Obtaining the channel");
        Optional<Channel> optionalChannel = channelRepository.findById(channelId);
//        log.info(principal.toString());
//        log.info(p.toString());
        log.info("Channel is Optional");
        if (optionalChannel.isPresent()) {
            log.info("Channel is present");
            Channel channel = optionalChannel.get();
            Message message = new Message(p.getName(), body, channel);
            this.messagesRepository.save(message);
            this.template.convertAndSendToUser(p.getName(), "/channel/reply", "message");
            this.template.convertAndSend("/channel/room/" + channelId, "message");
        } else {
            return new ApiResponse(false,"Channel is not present.");
        }

        return true;
    }
}