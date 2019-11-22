package com.dating.server.controller;

import com.dating.server.dto.GeoIP;
import com.dating.server.model.Channel;
import com.dating.server.model.Like;
import com.dating.server.model.Match;
import com.dating.server.payload.request.AddPhotoRequest;
import com.dating.server.payload.request.LikeRequest;
import com.dating.server.payload.response.ApiResponse;
import com.dating.server.payload.response.LikeResponse;
import com.dating.server.repository.LikeRepository;
import com.dating.server.repository.MatchRepository;
import com.dating.server.repository.PhotoRepository;
import com.dating.server.repository.UserRepository;
import com.dating.server.security.CurrentUser;
import com.dating.server.security.UserPrincipal;
import com.maxmind.geoip2.exception.AddressNotFoundException;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;

@Tag(name = "Photos")
@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("photo")
@CommonsLog(topic = "PhotoController")
public class PhotoController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    PhotoRepository photoRepository;

    @PostMapping(value = "/")
    @Transactional
    public ResponseEntity<?> create(
            @Valid @RequestBody AddPhotoRequest addPhotoRequest,
            Authentication authentication,
            @CurrentUser UserPrincipal userPrincipal
    ) {
        return ResponseEntity.ok().body(true);
    }

}
