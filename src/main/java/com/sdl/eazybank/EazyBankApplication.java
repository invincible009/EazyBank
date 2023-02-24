package com.sdl.eazybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EazyBankApplication {

  public static void main(String[] args) {
    SpringApplication.run(EazyBankApplication.class, args);
  }

}
