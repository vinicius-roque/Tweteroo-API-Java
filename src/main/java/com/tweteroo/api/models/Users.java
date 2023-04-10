package com.tweteroo.api.models;

import com.tweteroo.api.DTO.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Users {

  public Users(UserDTO data) {
    this.username = data.username();
    this.avatar = data.avatar();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 30, nullable = false)
  private String username;

  @Column(length = 300, nullable = false)
  private String avatar;
}