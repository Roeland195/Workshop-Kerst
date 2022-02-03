package com.example.ChristmasSweather.jwt;

import com.example.ChristmasSweather.Models.Account;
import com.example.ChristmasSweather.Models.Role;
import com.example.ChristmasSweather.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtAuthenticationManager implements AuthenticationManager {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        String email = authentication.getPrincipal() + "";
        String password = authentication.getCredentials() + "";

        Optional<Account> account = accountRepository.findByEmail(email);
        if(account.isEmpty()){
            throw new BadCredentialsException("");
        }
        if(!userDetailsService.doPasswordsMatch(password,account.get().getPassword())){
            throw new BadCredentialsException("");
        }
        Set<Role> roles = account.get().getRoles();
        return new UsernamePasswordAuthenticationToken(email,null,roles.stream()
                .map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toList()));
    }
}
