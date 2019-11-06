package com.dating.server.model;

import com.dating.server.model.audit.DateAudit;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "_like")
@IdClass(Like.LikeId.class)
@Embeddable
public class Like extends DateAudit implements Serializable {

    @Id
    private String senderUsername;
    @Id
    private String likedUsername;
    private boolean l;

    public Like(){

    }

    public Like(String senderUsername, String likedUsername, boolean l) {
        this.senderUsername = senderUsername;
        this.likedUsername = likedUsername;
        this.l = l;
    }

    public static class LikeId implements Serializable {

        @Getter private String senderUsername;
        @Getter private String likedUsername;

        public LikeId() {}

        public LikeId(String senderUsername, String likedUsername) {
            this.senderUsername = senderUsername;
            this.likedUsername = likedUsername;
        }

        @Override
        public boolean equals(Object o) {

            if (o == this) {
                return true;
            }
            if (!(o instanceof LikeId)) {
                return false;
            }
            LikeId likeId = (LikeId) o;
            return (Objects.equals(senderUsername, likeId.getSenderUsername()) &&
                    Objects.equals(likedUsername, likeId.getLikedUsername())) || (Objects.equals(senderUsername, likedUsername));
        }

        @Override
        public int hashCode() {
            return Objects.hash(senderUsername, likedUsername);
        }
    }

}