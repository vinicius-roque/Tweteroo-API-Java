package com.tweteroo.api.DTO;

import jakarta.validation.constraints.NotBlank;

public record TweetsDTO(
    @NotBlank String username,
    @NotBlank String tweet) {
}
