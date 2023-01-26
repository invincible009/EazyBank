package com.sdl.eazybank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController extends PublicBaseApiController {


  @GetMapping("contact")
  public String saveContact(){
    return "Welcome to Eazy Bank Application Contact Controller";
  }

}
