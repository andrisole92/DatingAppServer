package com.dating.server.controller;


import com.dating.server.dto.GeoIP;
import com.dating.server.model.User;
import com.dating.server.payload.response.ApiResponse;
import com.dating.server.repository.UserRepository;
import com.dating.server.service.GeoIpService;
import com.maxmind.geoip2.exception.AddressNotFoundException;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;

@Tag(name = "User Search")
@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping(value = "user/search", produces = {"application/json"})
@CommonsLog(topic = "User Search")
public class UserSearchController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GeoIpService geoIpService;

    @GetMapping(value = "/")
    @Transactional
    @Operation(summary = "Search users obviously")
    public ResponseEntity<?> index() throws IOException, GeoIp2Exception, AddressNotFoundException {
        GeoIP geoIP = null;
        String ip = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getRemoteAddr();
        log.info(ip);
        try {
            geoIP = geoIpService.getLocation(ip);
        } catch (Exception ignored){

        }
        throw new GeoIp2Exception("Boo!");
//        Page<User> userPage = userRepository.findAll(PageRequest.of(0,50));
//        return ResponseEntity.ok().body(new ApiResponse(true, userPage));
    }


//    // find by location
//    @RequestMapping("/fbl")
//    @ResponseBody
//    public Page<User> findAllByCoordinates(@RequestParam(defaultValue = "0") double lat,
//                                               @RequestParam(defaultValue = "0") double lng,
//                                               @RequestParam(defaultValue = "0") double distance,
//                                               @RequestParam(defaultValue = "0") int page) {
//        return userRepository.findAllByCoordinates(lat, lng, distance, PageRequest.of(page, 20));
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ResponseBody
//    public Object findByPage(
//            @RequestParam(defaultValue = "0") String pageNumber,
//            HttpSession httpSession
//    ) {
//        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String from = principal.getUsername();
//        try {
//            return userRepository.findAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return e.getMessage();
//        }
//    }

}