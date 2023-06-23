package com.soldincrease.GymServices.service;


import com.soldincrease.GymServices.dto.HeaderDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;


@AllArgsConstructor
@Service
public class JwtService implements IJwtService {
    public static final String SECRET = "e9d4c7d8674af705eee36b7b06998cac1c0fef8e024b2cd7e952d034a4a517a5";



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
