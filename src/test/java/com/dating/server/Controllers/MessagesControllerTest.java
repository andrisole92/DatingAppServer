//package com.dating.server.Controllers;
//
//
//import com.dating.server.payload.SendMessageRequest;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.apachecommons.CommonsLog;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.junit.After;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.MediaType;
//import org.springframework.messaging.converter.StringMessageConverter;
//import org.springframework.messaging.simp.stomp.*;
//import org.springframework.web.socket.WebSocketHttpHeaders;
//import org.springframework.web.socket.client.standard.StandardWebSocketClient;
//import org.springframework.web.socket.messaging.WebSocketStompClient;
//import org.springframework.web.socket.sockjs.client.SockJsClient;
//import org.springframework.web.socket.sockjs.client.Transport;
//import org.springframework.web.socket.sockjs.client.WebSocketTransport;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.socket.messaging.WebSocketStompClient;
//import org.springframework.web.socket.sockjs.client.SockJsClient;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.lang.reflect.Type;
//
//import java.net.URISyntaxException;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.Consumer;
//
//import static java.util.Arrays.asList;
//import static java.util.concurrent.TimeUnit.SECONDS;
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//public class MessagesControllerTest {
//    @Value("${local.server.port}")
//    private int port;
//    private Log LOGGER = LogFactory.getLog(MessagesControllerTest.class);
//
//
//    private static final String SEND_CREATE_BOARD_ENDPOINT = "/app/create";
//    private static final String SEND_MOVE_ENDPOINT = "/app/move/";
//    private static final String SUBSCRIBE_CREATE_BOARD_ENDPOINT = "/topic/board";
//    private static final String SUBSCRIBE_MOVE_ENDPOINT = "/topic/move/";
//    private static final String SUBSCRIBE_CHANNEL = "/channel/";
//
//    private StompSession session;
//
//
//    String WEBSOCKET_URI = "ws://localhost:"+port+"/app";
//    static final String WEBSOCKET_TOPIC = "/topic";
//
//    private BlockingQueue<String> blockingQueue;
//    private WebSocketStompClient stompClient;
//
//
//    private CompletableFuture<Object> completableFuture;
//    private CompletableFuture<String> resultKeeper = new CompletableFuture<>();
//
//    @Autowired
//    private MockMvc mockMvc;
//    private String URL;
//
//
//    @Before
//    @WithMockUser(username = "user1", password = "password", roles = "USER")
//    public void setup() throws InterruptedException, ExecutionException, TimeoutException {
//        WEBSOCKET_URI = "ws://localhost:"+port+"/app";
//        LOGGER.info(WEBSOCKET_URI);
//        blockingQueue = new LinkedBlockingDeque<>();
//        stompClient = new WebSocketStompClient(new SockJsClient(
//                asList(new WebSocketTransport(new StandardWebSocketClient()))));
//
//        final List<Transport> transportList = Collections.singletonList(new WebSocketTransport(new StandardWebSocketClient()));
//        final WebSocketStompClient stompClient = new WebSocketStompClient(new SockJsClient(transportList));
//        stompClient.setMessageConverter(new StringMessageConverter());
////        subscriptionCountDownLatch = new CountDownLatch(1);
////        subscriptionListener.registerCallback(e -> subscriptionCountDownLatch.countDown());
//
//        session = stompClient.connect(WEBSOCKET_URI, new MySessionHandler()).get(5, SECONDS);
//        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
//
////        subscriptionCountDownLatch.await(10, SECONDS);
//
//        Thread.sleep(20);
//    }
//
//
//    @After
//    public void reset() {
////        subscriptionListener.removeAllCallbacks();
//        session.disconnect();
//    }
//    @Test
//    @WithMockUser(username = "user1", password = "password", roles = "USER")
//
//    public void testCreateGameEndpoint() throws URISyntaxException, InterruptedException, ExecutionException, TimeoutException {
//
//
////        session = stompClient.connect(WEBSOCKET_URI, new MySessionHandler()).get(5, SECONDS);
////
//
//
//        session.subscribe(SUBSCRIBE_CREATE_BOARD_ENDPOINT, new DefaultStompFrameHandler());
//        session.send(SEND_CREATE_BOARD_ENDPOINT, null);
//
//        String received = blockingQueue.poll(3, SECONDS);
//        LOGGER.info(received);
//        assertNotNull(received);
//    }
//    @Test
//    @WithMockUser(username = "user1", password = "password", roles = "USER")
//    public void testSendMessage() throws Exception {
//        LOGGER.info("testSendMessage");
//
////        String plainCredentials = "user1:password";
////        String base64Credentials = Base64.getEncoder().encodeToString(plainCredentials.getBytes());
////
////        final WebSocketHttpHeaders headers = new WebSocketHttpHeaders();
////        headers.add("Authorization", "Basic " + base64Credentials);
//
//        session.subscribe(SUBSCRIBE_CHANNEL+"173", new DefaultStompFrameHandler());
//        session.subscribe(SUBSCRIBE_MOVE_ENDPOINT, new DefaultStompFrameHandler());
////        stompSession.send(SEND_CREATE_BOARD_ENDPOINT + uuid, null);
////        Thread.sleep(2000);
//
//        this.mockMvc.perform(post("/message/send_message")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(new SendMessageRequest(Long.valueOf("173"), "BODY BODY"))));
////                .param("body", "Hello World Test!")
////                .param("channelId", "173"))
////                .andExpect(status().isOk());
////                .andExpect(jsonPath("$.user.username", is("user1")))
////                .andExpect(jsonPath("$.message", is("Authenticated")))
////                .andExpect(jsonPath("$.success", is(true)))
//////                .andExpect(jsonPath("$", hasSize(1)))
////                .andReturn().getResponse().getStatus();
////        Thread.sleep(1000);
//        String received = blockingQueue.poll(3, SECONDS);
//        LOGGER.info(received);
////        try {
//////            Object gameState = completableFuture.get(20, SECONDS);
////            String gameState = resultKeeper.get(1, SECONDS);
////            System.out.println("gameStategameState");
////            System.out.println("gameStategameState");
////            System.out.println("gameStategameState");
////            System.out.println("gameStategameState");
////            System.out.println(gameState);
////            System.out.println(gameState);
////            System.out.println(gameState);
////            System.out.println(gameState);
////            System.out.println(gameState);
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//
//
//    }
//
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private List<Transport> createTransportClient() {
//        List<Transport> transports = new ArrayList<>(1);
//        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
//        return transports;
//    }
//
//    private class CreateGameStompFrameHandler implements StompFrameHandler {
//        @Override
//        public Type getPayloadType(StompHeaders stompHeaders) {
//            return String.class;
//        }
//
//        @Override
//        public void handleFrame(StompHeaders stompHeaders, Object o) {
//            System.out.println("Session");
//            completableFuture.complete((String) o);
//        }
//    }
//
//    private class MyStompFrameHandler implements StompFrameHandler {
//
//        private final Consumer<String> frameHandler;
//
//        @Override
//        public Type getPayloadType(StompHeaders stompHeaders) {
//            return Object.class;
//        }
//
//        public MyStompFrameHandler(Consumer<String> frameHandler) {
//            this.frameHandler = frameHandler;
//        }
//
//        @Override
//        public void handleFrame(StompHeaders headers, Object payload) {
////            System.out.println("received message: {} with headers: {}", payload, headers);
//            System.out.println("received message: {} with headers: {}");
//            frameHandler.accept(payload.toString());
//        }
//    }
//
//    private class MySessionHandler extends StompSessionHandlerAdapter {
////        @Override
////        public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
////            session.subscribe(SUBSCRIBE_CREATE_BOARD_ENDPOINT, this);
////        }
//
//        @Override
//        public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
//            LOGGER.warn("Stomp Error:", exception);
//        }
//
//        @Override
//        public void handleTransportError(StompSession session, Throwable exception) {
//            super.handleTransportError(session, exception);
//            LOGGER.warn("Stomp Transport Error:", exception);
//        }
//
//        @Override
//        public Type getPayloadType(StompHeaders headers) {
//            return String.class;
//        }
//
//        @Override
//        @SuppressWarnings("unchecked")
//        public void handleFrame(StompHeaders stompHeaders, Object o) {
//            LOGGER.info(String.format("Handle Frame with payload: %s", o.toString()));
//            try {
//                blockingQueue.offer((String) o, 1, SECONDS);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    class DefaultStompFrameHandler implements StompFrameHandler {
//        @Override
//        public Type getPayloadType(StompHeaders headers) {
//            return String.class;
//        }
//
//        @Override
//        public void handleFrame(StompHeaders stompHeaders, Object o) {
//            LOGGER.info(String.format("Handle Frame with payload: %s", o.toString()));
//            try {
//                blockingQueue.offer((String) o, 1, SECONDS);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//}
//
//
