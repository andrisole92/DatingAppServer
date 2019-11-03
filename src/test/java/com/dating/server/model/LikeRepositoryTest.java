package com.dating.server.model;

import com.dating.server.repository.LikeRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class LikeRepositoryTest {

    @Autowired
    private LikeRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void updateUserLike() {
    }

    @Test
    public void createLike() {
//        Like l = new Like("1", "2", true);
//        System.out.println(l);
//        try{
//            repository.save(l);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }
}