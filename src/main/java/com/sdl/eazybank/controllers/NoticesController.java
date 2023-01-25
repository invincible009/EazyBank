package com.sdl.eazybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticesController {


  @GetMapping("/notices")
  public String welcomeMessage(){
    return "Welcome to Eazy Bank Application Notices Controller";
  }

}
