package com.issuetracker.engine.filter;

import com.issuetracker.engine.exception.NotFoundException;
import com.issuetracker.engine.model.UserCredentials;
import com.issuetracker.engine.repository.UserDetailsRepository;
import com.issuetracker.engine.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

public class AuthFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    private final UserDetailsRepository userDetailsRepository;

    public AuthFilter(TokenService tokenService, UserDetailsRepository userDetailsRepository) {
        this.tokenService = tokenService;
        this.userDetailsRepository = userDetailsRepository;
    }
    
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
        String token = getBearerToken(request);

        if (tokenService.isValid(token)){
            authByToken(token);
        }

        filterChain.doFilter(request, response);
    }

    private void authByToken(String token) {
        //recuperar o id do usuário
        Long userId = tokenService.getUserId(token);
        var userOpt = userDetailsRepository.findById(userId);

        if (userOpt.isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }
        UserCredentials userCredentials = userOpt.get();
        //autenticar no Spring

        UsernamePasswordAuthenticationToken userAuth
                = new UsernamePasswordAuthenticationToken(userCredentials, null, userCredentials.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(userAuth);

    }

    private String getBearerToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (Objects.isNull(token) || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7,token.length());

    }
}
