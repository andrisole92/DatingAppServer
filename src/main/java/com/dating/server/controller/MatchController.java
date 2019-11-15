package com.dating.server.controller;


//import com.dating.server.security.UserPrincipal_v2;
//import com.dating.server.Xmpp.DataJpa.XmppUser;
import com.dating.server.model.User;
import com.dating.server.repository.MatchRepository;
import com.dating.server.security.UserPrincipal;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Tag(name = "Match")
@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("match")
@CommonsLog(topic = "MatchesController")
public class MatchController {

    @Autowired
    MatchRepository matchRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Object findByPage(
            @RequestParam(defaultValue = "0") String pageNumber,
            HttpSession httpSession
    ) {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String from = principal.getUsername();
        try {
            return matchRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}