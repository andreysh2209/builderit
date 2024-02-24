package com.example.builderit.controllers;


import com.example.builderit.dto.JwtRequestDto;
import com.example.builderit.dto.JwtResponseDto;
import com.example.builderit.exceptions.NotValidCredentials;
import com.example.builderit.services.CustomUserDetailsService;
import com.example.builderit.utils.JwtTokenUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin ("http://localhost:3000/")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtTokenUtils jwtTokenUtils;

    public AuthController(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, JwtTokenUtils jwtTokenUtils) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtTokenUtils = jwtTokenUtils;
    }

     @PostMapping("/auth")
    public ResponseEntity<?> createToken(@RequestBody JwtRequestDto jwtRequestDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequestDto.getUsername()
                    ,jwtRequestDto.getPassword()));
        }catch (BadCredentialsException e) {
            return new ResponseEntity<>(new NotValidCredentials(HttpStatus.UNAUTHORIZED.value(), "Wrong credentials")
                    , HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequestDto.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponseDto(token));
    }

}
