
package com.leomarqz.bank.security;

import com.leomarqz.bank.auth_users.entity.User;
import com.leomarqz.bank.auth_users.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return AuthUser
                .builder()
                .user(user)
                .build();
    }
}
