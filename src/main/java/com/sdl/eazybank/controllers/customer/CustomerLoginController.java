package com.sdl.eazybank.controllers.customer;

import com.sdl.eazybank.Dto.CustomerDto;
import com.sdl.eazybank.Dto.api.ApiResponse;
import com.sdl.eazybank.controllers.PublicBaseApiController;
import com.sdl.eazybank.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerLoginController extends PublicBaseApiController {

  private final  Logger logger = LoggerFactory.getLogger(CustomerLoginController.class);

  private final CustomerService customerService;

  public CustomerLoginController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping("register")
  public ResponseEntity<ApiResponse> registerUser(@RequestBody CustomerDto customerDto){
    return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.OK);
  }
}
