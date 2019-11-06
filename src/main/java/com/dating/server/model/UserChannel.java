//package com.dating.server.model;
//
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Data
////@Transactional
//@Entity // This tells Hibernate to make a table out of this class
//@Table(name = "user_channel")
//public class UserChannel implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;
//
//    @ManyToOne
////    @MapsId("user_id")
//    @JoinColumn(name = "user_id")
//    User user;
//
//    @ManyToOne
////    @MapsId("channel_id")
//    @JoinColumn(name = "channel_id")
//    Channel channel;
//
//    public UserChannel(){
//
//    }
//
//    public UserChannel(User user, Channel channel){
//        this.user = user;
//        this.channel = channel;
//    }
//}
//
////@Embeddable
////class UserChannelKey implements Serializable {
////
////    @Column(name = "user_id")
////    String userId;
////
////    @Column(name = "channel_id")
////    Long channelId;
////
////    // standard constructors, getters, and setters
////    // hashcode and equals implementation
////}