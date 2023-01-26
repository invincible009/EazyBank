package com.sdl.eazybank.service.impl;

import com.sdl.eazybank.Dto.CustomerDto;
import com.sdl.eazybank.Dto.api.ApiResponse;
import com.sdl.eazybank.entity.Customer;
import com.sdl.eazybank.repo.CustomerRepository;
import com.sdl.eazybank.service.CustomerService;
import com.sdl.eazybank.service.customer.CustomerFactory;
import com.sdl.eazybank.service.customer.CustomerValidator;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

  private final CustomerRepository customerRepository;
  private final CustomerFactory customerFactory;
  private final CustomerValidator customerValidator;
  private final ModelMapper modelMapper;


  public CustomerServiceImpl(CustomerRepository customerRepository, CustomerFactory customerFactory,
      CustomerValidator customerValidator, ModelMapper modelMapper) {
    this.customerRepository = customerRepository;
    this.customerFactory = customerFactory;
    this.customerValidator = customerValidator;
    this.modelMapper = modelMapper;
  }

  @Override
  public ApiResponse createCustomer(CustomerDto dto) {
    try{
      customerValidator.validate(dto);
      Customer customer = (Customer) customerFactory.create(dto);
      customerRepository.save(customer);
      return new ApiResponse(HttpStatus.CREATED, "Given user details are registered successfuly", null);
    }catch (Exception e){
      return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An Exception occurred due to ", e.getMessage());
    }
  }
}
