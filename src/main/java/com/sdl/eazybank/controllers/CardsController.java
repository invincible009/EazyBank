package com.sdl.eazybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardsController {


  @GetMapping("/cards")
  public String welcomeMessage(){
    return "Welcome to Eazy Bank Application Cards Controller";
  }

}
