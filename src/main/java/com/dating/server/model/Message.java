package com.dating.server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String sender;

    private String body;
    private String type;
    private String subject;
    private Date created_at = new Date(System.currentTimeMillis());
    private Date updated_at = new Date(System.currentTimeMillis());

    @ManyToOne(targetEntity = Channel.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    private Channel channel;

    public Message(String sender, String body, Channel channel) {
        this.sender = sender;
        this.body = body;
        this.channel = channel;
    }

    public Message(){

    }
}