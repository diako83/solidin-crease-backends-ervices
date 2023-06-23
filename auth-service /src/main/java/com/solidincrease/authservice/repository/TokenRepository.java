package com.solidincrease.authservice.repository;

import com.solidincrease.authservice.entity.Token;
import com.solidincrease.authservice.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Integer> {
    Optional<Token> findByToken(String token);

    boolean existsByToken(String token);
}
