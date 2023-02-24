package com.sdl.eazybank.controllers;

import com.sdl.eazybank.Dto.NoticeResponse;
import com.sdl.eazybank.service.NoticeService;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController extends PublicBaseApiController {

  private final NoticeService noticeService;

  public NoticesController(NoticeService noticeService) {
    this.noticeService = noticeService;
  }


  @GetMapping("notices")
  public ResponseEntity<NoticeResponse> welcomeMessage(){
    NoticeResponse noticeResponse = noticeService.retrieveAllNotices();
    return  ResponseEntity.ok()
            .cacheControl(CacheControl.maxAge(60, TimeUnit.MILLISECONDS))
            .body(noticeResponse);
  }


}
