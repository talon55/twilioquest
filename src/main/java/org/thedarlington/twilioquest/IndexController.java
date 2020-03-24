package org.thedarlington.twilioquest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  Logger logger = LoggerFactory.getLogger(IndexController.class);

  @GetMapping("/")
  public String index() {
    return "It works!";
  }

  @GetMapping("/greeting")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    String greeting = String.format("Hello %s!", name);
    logger.info(greeting);
    return greeting;
  }
}
