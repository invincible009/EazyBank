package com.sdl.eazybank.config;

import com.sdl.eazybank.entity.Customer;
import com.sdl.eazybank.repo.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
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
    List<Customer> customerList = repository.findByEmail(username);
    if (customerList.size() > 0) {
      if (passwordEncoder.matches(pwd, customerList.get(0).getPwd())) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customerList.get(0).getRole()));
        return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
      } else {
        throw new BadCredentialsException("Invalid Password");
      }
    } else {
      throw new BadCredentialsException("No user registered with this details");
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
