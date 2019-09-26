package com.dating.server.JPA;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String _from;
    private String _to;

    private String body;
    private String type;
    private String subject;
    private boolean s = false;
    private Date created_at = new Date(System.currentTimeMillis());

}