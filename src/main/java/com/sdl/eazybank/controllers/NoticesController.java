package com.sdl.eazybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController extends PublicBaseApiController {



  @GetMapping("notices")
  public String welcomeMessage(){
    return "Welcome to Eazy Bank Application Notices Controller";
  }


}
