package com.sdl.eazybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


  @GetMapping("/welcome")
  public String welcomeMessage(){
    return "Welcome to Eazy Bank Application";
  }

}
