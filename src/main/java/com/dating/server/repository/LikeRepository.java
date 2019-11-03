package com.dating.server.repository;

//import com.dating.server.Xmpp.DataJpa.XmppUser;
import com.dating.server.model.Like;
import com.dating.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Like.LikeId> {


    // Paid Feature
    @Modifying
    @Query("update Like l set l.l = ?1, l.senderUsername = ?2 where l.likedUsername = ?3")
    void updateUserLike(boolean like, String senderUsername, String likedUsername);

    List<Like> findBysenderUsernameAndL(String senderUsername, boolean l);


    List<Like> findBylikedUsernameAndL(String likedUsername, boolean l);

    @Query(value = "SELECT DISTINCT l1.senderUsername, l1.likedUsername, l1.l, u.full_name from Like l1 " +
            "INNER JOIN User u " +
            "ON u.username = l1.senderUsername " +
            "WHERE NOT EXISTS (SELECT l.senderUsername FROM Like l WHERE l.senderUsername = l1.likedUsername AND l.likedUsername = l1.senderUsername) AND l1.likedUsername = ?1 AND l1.l IS TRUE")
    List<User> findUsersWholLikeMe(String username);


    @Query(value = "SELECT l1 from Like l1 inner join Like l2 ON l1.likedUsername = l2.senderUsername AND l2.senderUsername = l1.likedUsername where l1.senderUsername = ?1", nativeQuery = false)
    List<Like> getMatchesAsLikes(String username);


}