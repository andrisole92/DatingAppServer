package com.dating.server.feature.likes;

import com.dating.server.model.Like;
import com.dating.server.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LikesFeature {

    @Autowired
    private static LikeRepository likeRepository;

    // like or dislike
    public static void like(String uid1, String uid2, boolean like) {
        // Update database here
        try {
            likeRepository.save(new Like(uid1, uid2, like));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // paid feature
    public static void updateLike(String uid1, String uid2, boolean like) {
        // Update database here
        try {
            likeRepository.updateUserLike(like, uid1, uid2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static class LikeFactory {
//
//        public static Like createLike(String uid1, String uid2, boolean like) {
//            Like l = new Like();
//            l.setUid1(uid1);
//            l.setUid2(uid2);
//            l.setL(like);
//            return l;
//        }
//    }
}


