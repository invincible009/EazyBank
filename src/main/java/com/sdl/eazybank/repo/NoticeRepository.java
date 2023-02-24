package com.sdl.eazybank.repo;

import com.sdl.eazybank.entity.NoticeDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends CrudRepository<NoticeDetails, Long> {

}
