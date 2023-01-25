package com.sdl.eazybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {


  @GetMapping("/account")
  public String welcomeMessage(){
    return "Welcome to Eazy Bank Application Account Department";
  }

}
