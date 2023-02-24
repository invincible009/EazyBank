package com.sdl.eazybank.service.impl;

import com.sdl.eazybank.Dto.CustomerDto;
import com.sdl.eazybank.Dto.api.ApiResponse;
import com.sdl.eazybank.entity.Customer;
import com.sdl.eazybank.repo.CustomerRepository;
import com.sdl.eazybank.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

  private final CustomerRepository customerRepository;
  private final ModelMapper modelMapper;


  public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
    this.customerRepository = customerRepository;

    this.modelMapper = modelMapper;
  }

  @Override
  public ApiResponse createCustomer(CustomerDto dto) {
    try{

      Customer customer = new Customer();
      customerRepository.save(customer);
      return new ApiResponse(HttpStatus.CREATED, "Given user details are registered successfuly", null);
    }catch (Exception e){
      return new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An Exception occurred due to ", e.getMessage());
    }
  }
}
