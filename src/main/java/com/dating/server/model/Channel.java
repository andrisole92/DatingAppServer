package com.dating.server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "channel")
@Embeddable
public class Channel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "channel")
    Set<UserChannel> userChannels;

//    @OneToMany(mappedBy = "message")
//    private Set<Message> message;
}