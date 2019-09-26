package com.dating.server.JPA;

import com.dating.server.Xmpp.DataJpa.XmppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Like.LikeId> {


    // Paid Feature
    @Modifying
    @Query("update Like l set l.l = ?1, l.uid1 = ?2 where l.uid2 = ?3")
    void updateUserLike(boolean like, String uid1, String uid2);

    List<Like> findByUid1AndL(String uid1, boolean l);


    List<Like> findByUid2AndL(String uid2, boolean l);

    @Query(value = "SELECT DISTINCT l1.uid1, l1.uid2, l1.l, u.full_name from Like l1 " +
            "INNER JOIN XmppUser u " +
            "ON u.username = l1.uid1 " +
            "WHERE NOT EXISTS (SELECT l.uid1 FROM Like l WHERE l.uid1 = l1.uid2 AND l.uid2 = l1.uid1) AND l1.uid2 = ?1 AND l1.l IS TRUE")
    List<XmppUser> findUsersWholLikeMe(String uid);


    @Query(value = "SELECT l1 from Like l1 inner join Like l2 ON l1.uid2 = l2.uid1 AND l2.uid1 = l1.uid2 where l1.uid1 = ?1", nativeQuery = false)
    List<Like> getMatchesAsLikes(String uid);


}