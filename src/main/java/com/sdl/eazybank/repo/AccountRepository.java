package com.sdl.eazybank.repo;

import com.sdl.eazybank.entity.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Accounts, Long> {


}
