package com.dating.server.model;

import com.dating.server.model.audit.DateAudit;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "readMarker")
//@Embeddable
public class ReadMarker extends DateAudit {
    @Id
    @Column(columnDefinition = "serial")
    @Generated(GenerationTime.INSERT)
    private long id;

    private String channelId;
    private String memberId;

    private Date t = new Date(System.currentTimeMillis());

}