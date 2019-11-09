//package com.dating.server.Controllers;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class AuthControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void index() throws Exception {
//        this.mockMvc.perform(get("/auth2/")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("Greetings from Auth Controller!")));
//    }
//
//    @Test
//    public void authenticate() throws Exception {
//        this.mockMvc.perform(post("/auth2/auth")
//                .param("username", "user1").param("password", "password"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.user.username", is("user1")))
//                .andExpect(jsonPath("$.message", is("Authenticated")))
//                .andExpect(jsonPath("$.success", is(true)))
////                .andExpect(jsonPath("$", hasSize(1)))
//                .andReturn().getResponse().getStatus();
//    }
//}