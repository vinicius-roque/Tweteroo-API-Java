package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tweteroo.api.DTO.TweetsDTO;
import com.tweteroo.api.models.Tweets;
import com.tweteroo.api.models.Users;
import com.tweteroo.api.repositories.AuthRepository;
import com.tweteroo.api.repositories.TweetsRepository;

@Service
public class TweetsService {

  @Autowired
  private TweetsRepository tweetsRepository;

  @Autowired
  private AuthRepository authRepository;

  public void saveTweet(TweetsDTO req) {
    Users userData = authRepository.findByUsername(req.username());
    String avatar = userData.getAvatar();
    Tweets tweet = new Tweets(req);
    tweet.setAvatar(avatar);
    tweetsRepository.save(tweet);
  }

  public List<Tweets> getTweetsByUsername(String data) {
    return tweetsRepository.findByUsername(data);
  }

  public List<Tweets> getTweetsByPage(int page) {
    Page<Tweets> tweetsPage = tweetsRepository.findAll(PageRequest.of(page, 5).withSort(Direction.DESC, "id"));
    return tweetsPage.getContent();
  }
}
