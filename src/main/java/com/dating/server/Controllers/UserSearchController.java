package com.dating.server.Controllers;


import com.dating.server.Xmpp.DataJpa.XmppUser;
import com.dating.server.Xmpp.DataJpa.XmppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("us")
public class UserSearchController {

    @Autowired
    XmppUserRepository xmppUserRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    // find by location
    @RequestMapping("/fbl")
    @ResponseBody
    public Page<XmppUser> findAllByCoordinates(@RequestParam(defaultValue = "0") double lat,
                                               @RequestParam(defaultValue = "0") double lng,
                                               @RequestParam(defaultValue = "0") double distance,
                                               @RequestParam(defaultValue = "0") int page) {
        return xmppUserRepository.findAllByCoordinates(lat, lng, distance, PageRequest.of(page, 20));
    }

}