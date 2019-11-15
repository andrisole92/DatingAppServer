package com.dating.server.controller;


import com.dating.server.payload.ApiResponse;
import com.dating.server.payload.UserSearchRequest;
import com.dating.server.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Tag(name = "User Search")
@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping(value = "users/search", consumes = {"application/json"}, produces = {"application/json"})
@CommonsLog(topic = "User Search")
public class UserSearchController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/")
    @Transactional
    @Operation(summary = "Search users obviously")
    public ResponseEntity<?> index(@Valid @RequestBody UserSearchRequest userSearchRequest) {
        return ResponseEntity.ok().body(new ApiResponse(true, "User registered successfully"));
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