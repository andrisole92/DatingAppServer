package com.dating.server.JPA;


import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<Match, Long> {


}