package com.dating.server.model;

import com.dating.server.model.audit.DateAudit;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "_match")
@IdClass(Match.MatchId.class)
@Embeddable
public class Match extends DateAudit implements Serializable {

//    @Column(columnDefinition = "serial")
//    @Generated(GenerationTime.INSERT)
//    private String id;

    @Id
    private String uid1;
    @Id
    private String uid2;

    // the person who swiped first
    private String initiatorUid;

    // indicates of conversation is started
    private boolean haveConversation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "_channel_id", referencedColumnName = "id")
    private Channel channel;

    public Match(){

    }

    public Match(String uid1, String uid2, Channel channel){
        this.uid1 = uid1;
        this.uid2 = uid2;
        this.channel = channel;
    }

    public static class MatchId implements Serializable {

        @Getter
        private String uid1;
        @Getter
        private String uid2;

        public MatchId() {
        }

        public MatchId(String uid1, String uid2) {
            this.uid1 = uid1;
            this.uid2 = uid2;
        }

        @Override
        public boolean equals(Object o) {

            if (o == this) {
                return true;
            }
            if (!(o instanceof MatchId)) {
                return false;
            }
            MatchId likeId = (MatchId) o;
            return Objects.equals(uid1, likeId.getUid1()) &&
                    Objects.equals(uid2, likeId.getUid2());
        }

        @Override
        public int hashCode() {
            return Objects.hash(uid1, uid2);
        }
    }

}