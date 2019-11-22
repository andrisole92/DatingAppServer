package com.dating.server.model;

import com.dating.server.model.audit.DateAudit;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "_channel")
public class Channel extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "_channel_user",
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            joinColumns = @JoinColumn(name = "channel_id"))
    private List<User> users = new ArrayList<User>();


//    @ManyToMany(mappedBy = "channel")
//    private Set<User> users = new HashSet<>();
//    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
//    Set<UserChannel> userChannels;

//    @OneToMany(mappedBy = "message")
//    private Set<Message> message;
}