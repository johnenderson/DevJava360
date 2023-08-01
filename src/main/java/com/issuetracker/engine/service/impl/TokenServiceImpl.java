package com.issuetracker.engine.service.impl;

import com.issuetracker.engine.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    @Value("${token.service.jwt.expirationTime}")
    private Long EXPIRATION_TIME;

    @Value("${token.service.jwt.signWith}")
    private String SIGNING_KEY;

    @Override
    public String getToken(Long userId) {

        Date today = new Date();
        Date expirationDate = new Date(today.getTime() + EXPIRATION_TIME);
        byte[] signingKey = SIGNING_KEY.getBytes();

        return Jwts.builder()
                .setIssuer("API IssueTrackerPro") //Este método define o emissor do token
                .setSubject(userId.toString()) // Este método define o assunto do token, que é geralmente o usuário para quem o token foi emitido
                .setIssuedAt(today) // Este método define a data e a hora em que o token foi emitido.
                .setExpiration(expirationDate) //  Este método define a data e a hora de expiração do token
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS256) // Este método assina o token usando o algoritmo e a chave secreta fornecidos. No código fornecido, o token é assinado usando o algoritmo HS256 e a chave secreta "123456"
                .compact(); // Este método gera o token JWT como uma string compacta e segura para URL
    }

    @Override
    public Boolean isValid(String token) {
        try {
            getClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Long getUserId(String token) {
        Jws<Claims> claims = getClaimsJws(token);
        return Long.parseLong(claims.getBody().getSubject());
    }

    private Jws<Claims> getClaimsJws(String token) {
        // Gera uma chave segura usando o algoritmo HS256
        byte[] signingKey = SIGNING_KEY.getBytes();

        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(signingKey))
                .build()
                .parseClaimsJws(token);
    }

}
