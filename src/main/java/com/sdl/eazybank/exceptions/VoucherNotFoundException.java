package com.sdl.eazybank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VoucherNotFoundException extends RuntimeException{
  @Serial
  private static final long serialVersionUID = -5218143265247846948L;

  public VoucherNotFoundException(String message) {
    super(message);
  }
}