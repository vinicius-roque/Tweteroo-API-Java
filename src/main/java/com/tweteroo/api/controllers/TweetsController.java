package com.tweteroo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.DTO.TweetsDTO;
import com.tweteroo.api.models.Tweets;
import com.tweteroo.api.services.TweetsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetsController {

  @Autowired
  private TweetsService service;

  @PostMapping
  public ResponseEntity<Object> create(@RequestBody @Valid TweetsDTO req) {
    service.saveTweet(req);
    return new ResponseEntity<>("OK", HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Tweets>> getLastTweets(@RequestParam(defaultValue = "0", required = false) int page) {

    List<Tweets> tweets = service.getTweetsByPage(page);
    return ResponseEntity.ok().body(tweets);
  }

  @GetMapping("/{username}")
  public ResponseEntity<List<Tweets>> getTweetsByUsername(@PathVariable() String username) {
    List<Tweets> userTweets = service.getTweetsByUsername(username);

    return ResponseEntity.ok().body(userTweets);
  }
}
