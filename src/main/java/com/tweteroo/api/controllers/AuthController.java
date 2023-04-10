package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.DTO.UserDTO;

@RestController
@RequestMapping("/sign-up")
public class AuthController {

  @PostMapping
  public String signUp(@RequestBody UserDTO req) {
    return "OK";
  }
}
