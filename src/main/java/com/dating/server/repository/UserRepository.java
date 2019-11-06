package com.dating.server.repository;

import com.dating.server.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

//    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Override
    Page<User> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM users WHERE ST_DWithin(geom, ST_SetSRID(ST_MakePoint(?1, ?2), 26910), ?3)", nativeQuery = true)
    Page<User> findAllByCoordinates(double lat, double lng, double maxDistance, Pageable pageable);

}
