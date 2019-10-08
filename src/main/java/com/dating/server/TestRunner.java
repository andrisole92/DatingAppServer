package com.dating.server;


import com.dating.server.JPA.Like;
import com.dating.server.JPA.LikeRepository;
import com.dating.server.JPA.MatchesRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;

import com.dating.server.Xmpp.DataJpa.XmppLastRepository;
import com.dating.server.Xmpp.DataJpa.XmppUser;
import com.dating.server.Xmpp.DataJpa.XmppUserRepository;
import com.github.javafaker.Faker;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
@CommonsLog(topic = "CounterLog")
public class TestRunner implements CommandLineRunner {
    //    @Autowired
//    private ArangoOperations operations;
//    @Autowired
//    private CharacterRepository repository;
    @Autowired
    private XmppUserRepository xmppUserRepository;
    @Autowired
    private MatchesRepository matchesRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private XmppLastRepository xmppLastRepository;
    private GeometryFactory geometryFactory = new GeometryFactory();

    @Override
    public void run(final String... args) throws Exception {
        Faker faker = new Faker();

        // first drop the database so that we can run this multiple times with the same dataset
//        operations.dropDatabase();
//
//        // save a single entity in the database
//        // there is no need of creating the collection first. This happen automatically
//        final Character nedStark = new Character("Ned", "Stark", true, 41);
//        repository.save(nedStark);
//        // the generated id from the database is set in the original entity
//        System.out.println(String.format("Ned Stark saved in the database with id: '%s'", nedStark.getId()));
//
////        // lets take a look whether we can find Ned Stark in the database
//        System.out.println(String.format("Found %s", repository.findById(nedStark.getId())));

////        long count = xmppUserRepository.count();
        try {
//            Page<XmppUser> xmppUsers = xmppUserRepository.findAll(PageRequest.of(0,20, Sort.by("password").descending()));
            Page<XmppUser> xmppUsers = xmppUserRepository.findAllByCoordinates(43,79,1000,PageRequest.of(0,20));
            for (XmppUser user : xmppUsers) {
                log.info(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("Successfully got users" + count);

        int i = 0;
        int x = 41;
        int y = 77;
//        log.info(faker.artist().name());

        while (i < 1000000) {
            try {
                XmppUser xmppUser = new XmppUser();
                xmppUser.setUsername("user" + i);
                xmppUser.setFull_name(faker.name().fullName());
                Point p = geometryFactory.createPoint(new Coordinate(faker.number().randomDouble(2, x, x + 4), faker.number().randomDouble(2, y, y + 4)));
//                p.setSRID(3857);
                p.setSRID(26910);


                xmppUser.setGeom(p);
                xmppUser.setPassword("password");
                xmppUser.setCreated_at(new Date(System.currentTimeMillis()));
                xmppUser.setSalt("");
                xmppUser.setServerkey("");
                xmppUserRepository.save(xmppUser);
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }

//        Like l = new Like("1","2",true);
//        l.setL(false);
//        l.setUid1("avc");
//        l.setUid2("12312312");
//        try{
//            likeRepository.save(l);
//        } catch (Exception e){
//            e.printStackTrace();
//        }

        try {
//            Page<XmppUser> xmppUsers = xmppUserRepository.findAll(PageRequest.of(0,20, Sort.by("password").descending()));
            Page<Like> likes = likeRepository.findAll(PageRequest.of(0,20));
            for (Like like : likes) {
                log.info(like.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            List<Like> likes = likeRepository.getMatchesAsLikes("a");
//            for (Like like : likes) {
//                log.info(like.toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Match m = new Match();
//        m.setUid1("uid1");
//        m.setUid2("uid2");
//        matchesRepository.save(m);
    }

    public Geometry wktToGeometry(String wellKnownText)
            throws ParseException {

        return new WKTReader().read(wellKnownText);
    }
}
