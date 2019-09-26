package com.dating.server.JPA;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "likes")
@IdClass(Like.LikeId.class)
@Embeddable
public class Like {
    @Id
    private String uid1;
    @Id
    private String uid2;
    private boolean l;

//    public Like(String uid1, String uid2, boolean l) {
//        this.uid1 = uid1;
//        this.uid2 = uid2;
//        this.l = l;
//    }

    public static class LikeId implements Serializable {

        @Getter private String uid1;
        @Getter private String uid2;

        public LikeId() {}

        public LikeId(String uid1, String uid2) {
            this.uid1 = uid1;
            this.uid2 = uid2;
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
            return Objects.equals(uid1, likeId.getUid1()) &&
                    Objects.equals(uid2, likeId.getUid2());
        }

        @Override
        public int hashCode() {
            return Objects.hash(uid1, uid2);
        }
    }

}