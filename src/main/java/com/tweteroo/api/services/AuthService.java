package com.tweteroo.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.DTO.UserDTO;
import com.tweteroo.api.models.Users;
import com.tweteroo.api.repositories.AuthRepository;

@Service
public class AuthService {

  @Autowired
  private AuthRepository repository;

  public void signUp(UserDTO data) {
    repository.save(new Users(data));
  }
}
