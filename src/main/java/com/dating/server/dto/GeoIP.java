package com.dating.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public @Data
@AllArgsConstructor
class GeoIP {
    private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;
}