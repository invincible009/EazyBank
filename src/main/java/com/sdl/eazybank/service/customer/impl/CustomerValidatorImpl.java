package com.sdl.eazybank.service.customer.impl;

import com.sdl.eazybank.Dto.CustomerDto;
import com.sdl.eazybank.service.customer.CustomerValidator;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidatorImpl implements CustomerValidator<CustomerDto> {

  @Override
  public void validate(CustomerDto customerDto) {
    //Todo validate the customer object
  }
}
