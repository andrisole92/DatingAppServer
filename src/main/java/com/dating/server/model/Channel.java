package com.dating.server.model;

import com.dating.server.model.audit.DateAudit;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "_channel")
@Embeddable
public class Channel extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "_channel_users",
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            joinColumns = @JoinColumn(name = "channel_id"))
    private Set<User> users = new HashSet<User>();


//    @ManyToMany(mappedBy = "channel")
//    private Set<User> users = new HashSet<>();
//    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
//    Set<UserChannel> userChannels;

//    @OneToMany(mappedBy = "message")
//    private Set<Message> message;
}