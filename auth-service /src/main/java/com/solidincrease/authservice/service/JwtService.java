package com.solidincrease.authservice.service;

import com.solidincrease.authservice.dto.HeaderDto;
import com.solidincrease.authservice.entity.Token;
import com.solidincrease.authservice.repository.TokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class JwtService implements  IJwtService {


    @Autowired
    public TokenRepository tokenRepository;


    public static final String SECRET = "e9d4c7d8674af705eee36b7b06998cac1c0fef8e024b2cd7e952d034a4a517a5";


    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }
    public String logoutToken(String token) {

        token = token.replace("Bearer ", "");

        String cheekToken = token.replace("Bearer ", "");
         Token repoToken =  tokenRepository.findByToken(cheekToken).orElse(null);
        if(repoToken == null) throw new RuntimeException("Token dose not exists ");

        tokenRepository.delete(repoToken);

        return "Token revoked";

    }


    public String generateToken(String userName,String id) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName,id);
    }

    private String createToken(Map<String, Object> claims, String userName,String id) {

        claims.put("userName", userName);
        claims.put("id", id);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +24 * 1000 * 60 * 60))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }


        public HeaderDto headerDeconstruct(String token) {

            token = token.replace("Bearer ", "");
            SecretKey secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET));

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String id = claims.get("id", String.class);
            String userName = claims.get("userName", String.class);
            String email = claims.get("email", String.class);

            HeaderDto headerDto = new HeaderDto(id,userName,email);

            return headerDto;
        }


}
