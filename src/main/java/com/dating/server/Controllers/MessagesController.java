package com.dating.server.Controllers;


import com.dating.server.Authentication.MyUserPrincipal;
import com.dating.server.JPA.MessagesRepository;
import com.dating.server.Xmpp.DataJpa.XmppUser;
import com.dating.server.Xmpp.XmppAdmin;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("messages")
@CommonsLog(topic = "MessagesController")
public class MessagesController {

    @Autowired
    XmppAdmin xmppAdmin;

    @Autowired
    MessagesRepository messagesRepository;

    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Messages Controller!";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseBody
    public Object send(
            @RequestParam(defaultValue = "") String to,
            @RequestParam(defaultValue = "") String subject,
            @RequestParam(defaultValue = "") String body,
            @RequestParam(defaultValue = "") String type,
            HttpSession httpSession
    ) {
        MyUserPrincipal principal = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XmppUser user = principal.getUser();
        String from = user.getUsername();
        String username =  ((MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        this.template.convertAndSendToUser(username, "/queue/reply", "message");

//        this.template.convertAndSend("/topic/greetings", new HelloMessage("Hello"));
        return true;
//        try {
//            xmppAdmin.sendMessage("", from, to, subject, body);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
    }
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Object test(
            @RequestParam(defaultValue = "") String to,
            @RequestParam(defaultValue = "") String subject,
            @RequestParam(defaultValue = "") String body,
            @RequestParam(defaultValue = "") String type,
            HttpSession httpSession,
            Principal p
    ) {
        log.info(httpSession.isNew());
        log.info(httpSession.getAttribute("test"));
        log.info(httpSession.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY));
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
//        XmppUser user = principal.getUser();
        log.info(principal.toString());
//        log.info(p.toString());
        log.info(name);
//        MyUserPrincipal principal = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        XmppUser user = principal.getUser();
//        String from = user.getUsername();
//        String username =  ((MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
//        this.template.convertAndSendToUser(username, "/queue/reply", "message");

        return true;
    }
}