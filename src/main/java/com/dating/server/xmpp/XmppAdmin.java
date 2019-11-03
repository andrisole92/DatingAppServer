//package com.dating.server.Xmpp;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.boot.configurationprocessor.json.JSONObject;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class XmppAdmin {
//    private final ObjectMapper objectMapper = new ObjectMapper();
//    private final String jabberUrl = "http://localhost:5280/";
//
//    public void register(String username, String password, String host) throws Exception {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        JSONObject personJsonObject = new JSONObject();
//        personJsonObject.put("id", 1);
//        personJsonObject.put("name", "John");
//        RestTemplate restTemplate = new RestTemplate();
//        HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
//        String personResultAsJsonStr = restTemplate.postForObject("createPersonUrl", request, String.class);
//        JsonNode root = objectMapper.readTree(personResultAsJsonStr);
//    }
//
//    public void sendMessage(String type, String from, String to, String subject, String body){
//
//    }
//}
