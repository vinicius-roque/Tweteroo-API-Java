package com.tweteroo.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.Tweets;

public interface TweetsRepository extends JpaRepository<Tweets, Long> {

}
