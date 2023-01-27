package com.sdl.eazybank.repo;

import com.sdl.eazybank.entity.ContactMessages;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<ContactMessages, Long> {


}
