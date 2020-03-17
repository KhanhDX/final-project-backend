package com.khanhdx.finalproject.domain.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
  private Integer id;

  @NotBlank
  private String username;

  @NotBlank
  private String password;
}
