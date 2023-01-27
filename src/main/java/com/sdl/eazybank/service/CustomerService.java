package com.sdl.eazybank.service;

import com.sdl.eazybank.Dto.CustomerDto;
import com.sdl.eazybank.Dto.api.ApiResponse;

public interface CustomerService {
  ApiResponse createCustomer(CustomerDto dto);

}
