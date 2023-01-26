package com.sdl.eazybank.service.customer;

public interface CustomerFactory<T, R>{
  T create(R r);
}
