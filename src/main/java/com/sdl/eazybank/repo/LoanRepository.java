package com.sdl.eazybank.repo;

import com.sdl.eazybank.entity.Loans;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loans, Long> {


}
