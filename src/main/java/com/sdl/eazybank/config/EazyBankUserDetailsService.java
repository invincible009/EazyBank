package com.sdl.eazybank.config;

import com.sdl.eazybank.entity.Customer;
import com.sdl.eazybank.repo.CustomerRepository;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class EazyBankUserDetailsService implements UserDetailsService {
  private final CustomerRepository repository;

  public EazyBankUserDetailsService(CustomerRepository repository)  {
    this.repository = repository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    List<Customer> customerList = repository.findByEmail(username);
    if(customerList.size() == 0){
      throw new UsernameNotFoundException("User Details not found for the user "+ username);
    }
    return new BankCustomer(customerList.get(0));
  }
}
