package com.dating.server.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MatchesRepository extends JpaRepository<Match, Match.MatchId> {


    // Paid Feature
    @Modifying
    @Query("update Match m set m.haveConversation = true where m.id = ?1")
    void conversationStarted();

//    @Query(value = "SELECT DISTINCT l1.uid1, l1.uid2, l1.l, u.full_name from Like l1 " +
//            "INNER JOIN XmppUser u " +
//            "ON u.username = l1.uid1 " +
//            "WHERE NOT EXISTS (SELECT l.uid1 FROM Like l WHERE l.uid1 = l1.uid2 AND l.uid2 = l1.uid1) AND l1.uid2 = ?1 AND l1.l IS TRUE")
//    List<XmppUser> findUsersWholLikeMe(String uid);
//
//
//    @Query(value = "SELECT l1 from Like l1 inner join Like l2 ON l1.uid2 = l2.uid1 AND l2.uid1 = l1.uid2 where l1.uid1 = ?1", nativeQuery = false)
//    List<Like> getMatchesAsLikes(String uid);


}