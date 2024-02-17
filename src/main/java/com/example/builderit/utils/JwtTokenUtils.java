package com.example.builderit.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
@Component
public class JwtTokenUtils {

    @Value("absshhdhhdhdhdhdhdhdhyeeei")
    private String secret;

    @Value("30m")
    private Duration jwtLife;

    public String generateToken (UserDetails userDetails) {
        Map <String, Object> claims = new HashMap();
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        claims.put("roles", roles);
        Date createDate = new Date();
        Date expirationDate = new Date(createDate.getTime()+jwtLife.toMillis());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(createDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

    }


    private Claims getClaimsFromToken (String token) {

        return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody();
    }
    public String getUsername(String token) {

        return getClaimsFromToken(token).getSubject();
    }

    public List <String> getUserRole (String token) {

        return getClaimsFromToken(token).get("roles", List.class);

    }
}
