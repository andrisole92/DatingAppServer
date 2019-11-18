package com.dating.server.model;

import com.dating.server.model.audit.DateAudit;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "_like")
@IdClass(Like.LikeId.class)
@Embeddable
public class Like extends DateAudit implements Serializable {

    @Id
    private Long senderId;
    @Id
    private Long likedId;
    private boolean l;

    public Like(){

    }

    public Like(Long senderId, Long likedId, boolean l) {
        this.senderId = senderId;
        this.likedId = likedId;
        this.l = l;
    }

    public static class LikeId implements Serializable {

        @Getter private Long senderId;
        @Getter private Long likedId;

        public LikeId() {}

        public LikeId(Long senderId, Long likedId) {
            this.senderId = senderId;
            this.likedId = likedId;
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
            return (Objects.equals(senderId, likeId.getSenderId()) &&
                    Objects.equals(likedId, likeId.getLikedId())) || (Objects.equals(senderId, likeId));
        }

        @Override
        public int hashCode() {
            return Objects.hash(senderId, likedId);
        }
    }

}