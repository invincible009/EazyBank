package com.sdl.eazybank.repo;

import com.sdl.eazybank.entity.Customer;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  Optional<Customer>  findByEmail(String email);

}
