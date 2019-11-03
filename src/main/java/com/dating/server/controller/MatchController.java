package com.dating.server.controller;


//import com.dating.server.security.UserPrincipal_v2;
//import com.dating.server.Xmpp.DataJpa.XmppUser;
import com.dating.server.model.User;
import com.dating.server.security.UserPrincipal;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("matches")
@CommonsLog(topic = "MatchesController")
public class MatchController {


//    @RequestMapping("/")
//    public String index() {
//        return "Greetings from Matches Controller!";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Object findByPage(
            @RequestParam(defaultValue = "") String pageNumber,
            HttpSession httpSession
    ) {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = principal.getUser();
        String from = principal.getUsername();
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}