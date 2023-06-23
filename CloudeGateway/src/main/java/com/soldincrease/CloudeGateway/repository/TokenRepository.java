package com.soldincrease.CloudeGateway.repository;

import com.soldincrease.CloudeGateway.entity.Token;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Integer> {
    Optional<Token> findByToken(String token);

    boolean existsByToken(String token);
}
