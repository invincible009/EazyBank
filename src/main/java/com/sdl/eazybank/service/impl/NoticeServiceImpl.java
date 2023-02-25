package com.sdl.eazybank.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdl.eazybank.Dto.NoticeResponse;
import com.sdl.eazybank.entity.NoticeDetails;
import com.sdl.eazybank.repo.NoticeRepository;
import com.sdl.eazybank.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;
    private final ObjectMapper mapper;

    public NoticeServiceImpl(NoticeRepository noticeRepository, ObjectMapper mapper) {
        this.noticeRepository = noticeRepository;
        this.mapper = mapper;
    }

    @Override
    public NoticeResponse retrieveAllNotices() {
        Iterable<NoticeDetails> notices = noticeRepository.findAll();
        return "allNotices" == null ? new NoticeResponse() : new NoticeResponse();
    }
}
