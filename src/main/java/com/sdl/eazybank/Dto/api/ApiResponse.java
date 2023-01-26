package com.sdl.eazybank.Dto.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude(Include.NON_NULL)
public class ApiResponse {


  private HttpStatus statusCode;
  private String message;
  private Object data;

  public ApiResponse(HttpStatus statusCode, String message, Object data) {
    this.statusCode = statusCode;
    this.message = message;
    this.data = data;
  }

  @Override
  public String toString() {
    return "Drone Response{" +
        "status Code=" + statusCode +
        ", message='" + message + '\'' +
        ", data=" + data +
        '}';
  }
}
