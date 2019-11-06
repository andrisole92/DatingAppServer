package com.dating.server.model;

import com.dating.server.model.audit.DateAudit;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "_message")
public class Message extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String sender;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "_sender_username", referencedColumnName = "username")
    private User user;

    private String body;
    private String type;
    private String subject;
//    private Date created_at = new Date(System.currentTimeMillis());
//    private Date updated_at = new Date(System.currentTimeMillis());

    @ManyToOne(targetEntity = Channel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "_channel_id", referencedColumnName = "id")
    private Channel channel;

    public Message(String sender, String body, Channel channel) {
        this.sender = sender;
        this.body = body;
        this.channel = channel;
    }

    public Message(User user, String body, Channel channel) {
        this.user = user;
        this.body = body;
        this.channel = channel;
    }

    public Message(){

    }
}