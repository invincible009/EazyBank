package com.sdl.eazybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController extends ProtectedBaseApiController {


  @GetMapping("cards")
  public String welcomeMessage(){
    return "Welcome to Eazy Bank Application Cards Controller";
  }

}
