package com.dating.server.service;

import com.dating.server.model.DeviceMetadata;
import com.dating.server.model.User;
import com.dating.server.repository.DeviceMetadataRepository;
import com.google.common.base.Strings;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;
import ua_parser.Client;
import ua_parser.Parser;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Service
@CommonsLog(topic = "DeviceService")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DeviceService {
    private static final String UNKNOWN = "UNKNOWN";

    @Autowired
    private DeviceMetadataRepository deviceMetadataRepository;

    private Parser parser = new Parser();

    @Autowired
    private GeoIpService geoIpService;

    public DeviceService() throws IOException {
    }

    public void verifyDevice(User user, HttpServletRequest request) throws IOException, GeoIp2Exception {

        String ip = extractIp(request);
        String location = getIpLocation(ip);

        String deviceDetails = getDeviceDetails(request.getHeader("user-agent"));

        DeviceMetadata existingDevice = findExistingDevice(user.getId(), deviceDetails, location);

        if (Objects.isNull(existingDevice)) {
            unknownDeviceNotification(deviceDetails, location, ip, user.getEmail(), request.getLocale());

            DeviceMetadata deviceMetadata = new DeviceMetadata();
            deviceMetadata.setUserId(user.getId());
            deviceMetadata.setLocation(location);
            deviceMetadata.setDeviceDetails(deviceDetails);
            deviceMetadata.setLastLoggedIn(new Date());
            deviceMetadataRepository.save(deviceMetadata);
        } else {
            existingDevice.setLastLoggedIn(new Date());
            deviceMetadataRepository.save(existingDevice);
        }

    }


    private String extractIp(HttpServletRequest request) {
        String clientIp;
        String clientXForwardedForIp = request.getHeader("x-forwarded-for");
        if (nonNull(clientXForwardedForIp)) {
            clientIp = parseXForwardedHeader(clientXForwardedForIp);
        } else {
            clientIp = request.getRemoteAddr();
        }

        return clientIp;
    }

    private String getIpLocation(String ip) throws IOException, GeoIp2Exception {

        String location = UNKNOWN;

        InetAddress ipAddress = InetAddress.getByName(ip);

        CityResponse cityResponse = geoIpService.getDbReader().city(ipAddress);
        if (Objects.nonNull(cityResponse) &&
                Objects.nonNull(cityResponse.getCity()) &&
                !Strings.isNullOrEmpty(cityResponse.getCity().getName())) {

            location = cityResponse.getCity().getName();
        }

        return location;
    }

    private String parseXForwardedHeader(String header) {
        return header.split(" *, *")[0];
    }


    private String getDeviceDetails(String userAgent) {
        String deviceDetails = UNKNOWN;

        Client client = parser.parse(userAgent);
        if (nonNull(client)) {
            deviceDetails = client.userAgent.family
                    + " " + client.userAgent.major + "."
                    + client.userAgent.minor + " - "
                    + client.os.family + " " + client.os.major
                    + "." + client.os.minor;
        }
        return deviceDetails;
    }

    private DeviceMetadata findExistingDevice(
            Long userId, String deviceDetails, String location) {
        List<DeviceMetadata> knownDevices
                = deviceMetadataRepository.findByUserId(userId);

        for (DeviceMetadata existingDevice : knownDevices) {
            if (existingDevice.getDeviceDetails().equals(deviceDetails)
                    && existingDevice.getLocation().equals(location)) {
                return existingDevice;
            }
        }
        return null;
    }

    private void unknownDeviceNotification(String deviceDetails, String location, String ip, String email, Locale locale) {
//        final String subject = "New Login Notification";
//        final SimpleMailMessage notification = new SimpleMailMessage();
//        notification.setTo(email);
//        notification.setSubject(subject);
//
//        String text = messages
//                .getMessage("message.login.notification.deviceDetails", null, locale) +
//                " " + deviceDetails +
//                "\n" +
//                messages
//                        .getMessage("message.login.notification.location", null, locale) +
//                " " + location +
//                "\n" +
//                messages
//                        .getMessage("message.login.notification.ip", null, locale) +
//                " " + ip;
//
//        notification.setText(text);
//        notification.setFrom(from);
//
//        mailSender.send(notification);
    }
}
