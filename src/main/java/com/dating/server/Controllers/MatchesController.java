package com.dating.server.Controllers;


import com.dating.server.Authentication.MyUserPrincipal;
import com.dating.server.Xmpp.DataJpa.XmppUser;
import com.dating.server.Xmpp.XmppAdmin;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("matches")
@CommonsLog(topic = "MatchesController")
public class MatchesController {


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
        MyUserPrincipal principal = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        XmppUser user = principal.getUser();
        String from = user.getUsername();
        try {
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}