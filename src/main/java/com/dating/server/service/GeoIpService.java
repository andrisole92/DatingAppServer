package com.dating.server.service;


import com.dating.server.dto.GeoIP;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
@CommonsLog(topic = "GeoIpService")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GeoIpService {
    private DatabaseReader dbReader;

    public GeoIpService() throws IOException, GeoIp2Exception {
        File f = new ClassPathResource("GeoLite/GeoLite2-City.mmdb").getFile();
        dbReader = new DatabaseReader.Builder(f).build();
//        log.info(dbReader.city(InetAddress.getByName("208.98.222.102")));
    }

    public GeoIP getLocation(String ip)
            throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);

        String cityName = response.getCity().getName();
        String latitude =
                response.getLocation().getLatitude().toString();
        String longitude =
                response.getLocation().getLongitude().toString();
        return new GeoIP(ip, cityName, latitude, longitude);
    }

    public DatabaseReader getDbReader() {
        return dbReader;
    }
}


