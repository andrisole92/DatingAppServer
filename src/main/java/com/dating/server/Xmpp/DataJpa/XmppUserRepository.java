package com.dating.server.Xmpp.DataJpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface XmppUserRepository extends JpaRepository<XmppUser, String> {

    //    @Override
//    Optional<XmppUser> findById(String id);
    XmppUser findByUsername(String username);

    @Override
    Page<XmppUser> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM users WHERE ST_DWithin(geom, ST_SetSRID(ST_MakePoint(?1, ?2), 26910), ?3)", nativeQuery = true)
    Page<XmppUser> findAllByCoordinates(double lat, double lng, double maxDistance, Pageable pageable);

//    @Query(value = "SELECT * FROM users WHERE password = 'password' LIMIT 10", nativeQuery = true)
//    Iterable<XmppUser> findAllByCoordinates(double lat, double lng, double maxDistance);
//    @Query(value = "SELECT * FROM users WHERE ST_DWithin(geom, ST_SetSRID(ST_MakePoint(?1, ?2), 3857), ?3)", nativeQuery = true)
//    Page<XmppUser> findAllByCoordinates(double lat, double lng, double maxDistance);

//    List<User> findTop20ByLastnameOrderByIdDesc(String lastname);

//    @Query(value = "SELECT u " +
//            "FROM XmppUser u " +
//            "INNER JOIN likes l1 " +
//            "ON l1.uid1 = u.username " +
//            "INNER JOIN likes l2 " +
//            "ON l1.uid1 = l2.uid2 AND l2.uid1 = l1.uid2 " +
//            "WHERE l1.uid2 = ?1 AND l1.l = TRUE AND l2.l = TRUE")
//    List<XmppUser> getAllMatches(String username);
}