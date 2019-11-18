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
    @Query("update Like l set l.l = ?1, l.senderId = ?2 where l.likedId = ?3")
    void updateUserLike(boolean like, String senderId, String likedId);

    List<Like> findBysenderIdAndL(String senderId, boolean l);


    List<Like> findBylikedIdAndL(String likedId, boolean l);

    @Query(value = "SELECT DISTINCT l1.senderId, l1.likedId, l1.l, u.full_name from Like l1 " +
            "INNER JOIN User u " +
            "ON u.username = l1.senderId " +
            "WHERE NOT EXISTS (SELECT l.senderId FROM Like l WHERE l.senderId = l1.likedId AND l.likedId = l1.senderId) AND l1.likedId = ?1 AND l1.l IS TRUE")
    List<User> findUsersWholLikeMe(Long username);


    @Query(value = "SELECT l1 from Like l1 inner join Like l2 ON l1.likedId = l2.senderId AND l2.senderId = l1.likedId where l1.senderId = ?1", nativeQuery = false)
    List<Like> getMatchesAsLikes(Long username);


}