package com.sdl.eazybank.service.customer.impl;

import com.sdl.eazybank.Dto.CustomerDto;
import com.sdl.eazybank.entity.Customer;
import com.sdl.eazybank.service.customer.CustomerFactory;
import java.sql.Date;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerFactoryImpl implements CustomerFactory<Customer, CustomerDto> {

  private final PasswordEncoder passwordEncoder;

  public CustomerFactoryImpl(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public Customer create(CustomerDto customerDto) {
    Customer customer = new Customer();
    customer.setName(customerDto.getName());
    customer.setEmail(customerDto.getEmail());
    customer.setMobileNumber(customerDto.getMobileNumber());
    customer.setPwd(passwordEncoder.encode(customerDto.getPwd()));
    customer.setRole(customerDto.getRole());
    customer.setCreateDt(new Date(System.currentTimeMillis()));
    return customer;
  }
}
