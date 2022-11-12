package com.sdl.eazybank.repo;

import com.sdl.eazybank.entity.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByEmail(String email);

}
