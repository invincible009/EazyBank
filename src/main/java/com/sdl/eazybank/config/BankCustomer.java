package com.sdl.eazybank.config;

import com.sdl.eazybank.entity.Customer;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BankCustomer implements UserDetails {

  private static final long serialVersionUID = -6690946490872875352L;
  private final Customer customer;

  public BankCustomer(Customer customer) {
    this.customer = customer;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(customer.getRole()));
    return authorities;
  }

  @Override
  public String getPassword() {
    return customer.getPwd();
  }

  @Override
  public String getUsername() {
    return customer.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
