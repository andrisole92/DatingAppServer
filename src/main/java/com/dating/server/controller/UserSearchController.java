package com.dating.server.controller;


import com.dating.server.model.User;
import com.dating.server.repository.UserRepository;
import com.dating.server.security.UserPrincipal;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Tag(name = "User Search")
@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("users/search")
@CommonsLog(topic = "User Search")
public class UserSearchController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    // find by location
    @RequestMapping("/fbl")
    @ResponseBody
    public Page<User> findAllByCoordinates(@RequestParam(defaultValue = "0") double lat,
                                               @RequestParam(defaultValue = "0") double lng,
                                               @RequestParam(defaultValue = "0") double distance,
                                               @RequestParam(defaultValue = "0") int page) {
        return userRepository.findAllByCoordinates(lat, lng, distance, PageRequest.of(page, 20));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Object findByPage(
            @RequestParam(defaultValue = "0") String pageNumber,
            HttpSession httpSession
    ) {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String from = principal.getUsername();
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}