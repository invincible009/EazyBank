package com.sdl.eazybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoansController {


  @GetMapping("/loans")
  public String welcomeMessage(){
    return "Welcome to Eazy Bank Application Loan Controller";
  }

}
