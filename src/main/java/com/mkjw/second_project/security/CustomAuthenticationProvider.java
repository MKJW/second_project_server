package com.mkjw.second_project.security;

import com.mkjw.second_project.entity.User;
import com.mkjw.second_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider extends DaoAuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final User user = userRepository.findByEmail(authentication.getName());

        if (user == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        // TODO 이 부분이 비밀번호 인증 또한 수행하는가? -> 그러니깐 비밀번호 틀리면 진행이 안되나..
        final Authentication result = super.authenticate(authentication);
        return new UsernamePasswordAuthenticationToken(user, result.getCredentials(), result.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
