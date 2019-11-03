package com.dating.server.Controllers;


import lombok.extern.apachecommons.CommonsLog;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@CommonsLog(topic = "MessagesControllerTest")
public class MessagesControllerTest {
    @Value("${local.server.port}")
    private int port;
    private static final String SEND_CREATE_BOARD_ENDPOINT = "/app/create/";
    private static final String SEND_MOVE_ENDPOINT = "/app/move/";
    private static final String SUBSCRIBE_CREATE_BOARD_ENDPOINT = "/channel/room/1";
    private static final String SUBSCRIBE_MOVE_ENDPOINT = "/user/channel/reply";
    private CompletableFuture<Object> completableFuture;
    CompletableFuture<String> resultKeeper = new CompletableFuture<>();

    @Autowired
    private MockMvc mockMvc;
    private String URL;


    @Before
    public void setup() {
        completableFuture = new CompletableFuture<>();

        System.out.println(port);
        System.out.println(port);
        System.out.println(port);
        System.out.println(port);
        URL = "ws://localhost:" + port + "/chat";
    }

    @Test
    @WithMockUser(username = "user1", password = "password", roles = "USER")
    public void send_message() throws Exception {
//        log.info(port);

        String plainCredentials = "user1:password";
        String base64Credentials = Base64.getEncoder().encodeToString(plainCredentials.getBytes());

        final WebSocketHttpHeaders headers = new WebSocketHttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);

        System.out.println("portportport");
        System.out.println("portportport");
        System.out.println("portportport");
        System.out.println("portportport");
        System.out.println("portportport");
        System.out.println(port);
        System.out.println(port);
        System.out.println(port);
        System.out.println(port);
        String uuid = UUID.randomUUID().toString();
//
        WebSocketStompClient stompClient = new WebSocketStompClient(new SockJsClient(createTransportClient()));
        stompClient.setMessageConverter(new StringMessageConverter());
//
        StompSession stompSession = stompClient.connect(URL, headers, new StompSessionHandlerAdapter() {
        }).get(1, SECONDS);
//
        stompSession.subscribe(SUBSCRIBE_CREATE_BOARD_ENDPOINT, new CreateGameStompFrameHandler());
        stompSession.subscribe(SUBSCRIBE_MOVE_ENDPOINT, new CreateGameStompFrameHandler());
//        stompSession.send(SEND_CREATE_BOARD_ENDPOINT + uuid, null);
        Thread.sleep(2000);

        this.mockMvc.perform(post("/messages/send_message")
                .param("body", "Hello World!")
                .param("channelId", "1"))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.user.username", is("user1")))
//                .andExpect(jsonPath("$.message", is("Authenticated")))
//                .andExpect(jsonPath("$.success", is(true)))
////                .andExpect(jsonPath("$", hasSize(1)))
//                .andReturn().getResponse().getStatus();
        Thread.sleep(1000);
        try {
//            Object gameState = completableFuture.get(20, SECONDS);
            String gameState = resultKeeper.get(1, SECONDS);
            System.out.println("gameStategameState");
            System.out.println("gameStategameState");
            System.out.println("gameStategameState");
            System.out.println("gameStategameState");
            System.out.println(gameState);
            System.out.println(gameState);
            System.out.println(gameState);
            System.out.println(gameState);
            System.out.println(gameState);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private List<Transport> createTransportClient() {
        List<Transport> transports = new ArrayList<>(1);
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        return transports;
    }

    private class CreateGameStompFrameHandler implements StompFrameHandler {
        @Override
        public Type getPayloadType(StompHeaders stompHeaders) {
            return String.class;
        }

        @Override
        public void handleFrame(StompHeaders stompHeaders, Object o) {
            System.out.println("Session");
            completableFuture.complete((String) o);
        }
    }

    private class MyStompFrameHandler implements StompFrameHandler {

        private final Consumer<String> frameHandler;

        @Override
        public Type getPayloadType(StompHeaders stompHeaders) {
            return Object.class;
        }

        public MyStompFrameHandler(Consumer<String> frameHandler) {
            this.frameHandler = frameHandler;
        }

        @Override
        public void handleFrame(StompHeaders headers, Object payload) {
//            System.out.println("received message: {} with headers: {}", payload, headers);
            System.out.println("received message: {} with headers: {}");
            frameHandler.accept(payload.toString());
        }
    }

}