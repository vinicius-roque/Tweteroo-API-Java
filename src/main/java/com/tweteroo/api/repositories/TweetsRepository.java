package com.tweteroo.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.Tweets;

public interface TweetsRepository extends JpaRepository<Tweets, Long> {
  List<Tweets> findByUsername(String username);
}
