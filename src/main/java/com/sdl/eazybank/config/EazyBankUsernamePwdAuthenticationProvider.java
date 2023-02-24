package com.sdl.eazybank.config;

import com.sdl.eazybank.entity.Customer;
import com.sdl.eazybank.repo.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AbstractUserDetailsReactiveAuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

@Service
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private final CustomerRepository repository;

    private final PasswordEncoder passwordEncoder;

    public EazyBankUsernamePwdAuthenticationProvider(CustomerRepository repository,
                                                     PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();

        Customer customer = findCustomerByUsername(username);

        if (verifyPassword(pwd, customer.getPwd())) {
            return createAuthenticationToken(username, pwd, customer.getRole());
        } else {
            throw new BadCredentialsException("Invalid Password");
        }

    }

    private Customer findCustomerByUsername(String username) {
        Customer customer = repository.findByEmail(username).get();
        if (customer != null) {
            return customer;
        }
        throw new UsernameNotFoundException("User Details not found for the user " + username);
    }

    private boolean verifyPassword(String enteredPwd, String storedPwd) {
        return passwordEncoder.matches(enteredPwd, storedPwd);
    }

    private Authentication createAuthenticationToken(String username, String pwd, String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
