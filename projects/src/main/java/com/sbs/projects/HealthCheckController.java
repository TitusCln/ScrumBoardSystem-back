package com.sbs.userStories;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController{

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public String getAllUsersStories() {
    return "I'm alive";
  }
}
