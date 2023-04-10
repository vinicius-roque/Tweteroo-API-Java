package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.DTO.TweetsDTO;
import com.tweteroo.api.models.Tweets;
import com.tweteroo.api.repositories.TweetsRepository;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

  @Autowired
  private TweetsRepository repository;

  @PostMapping
  public String create(@RequestBody TweetsDTO req) {
    repository.save(new Tweets(req));
    return "OK";
  }
}
