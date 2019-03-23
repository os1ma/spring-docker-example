package springdockerexample.presentation.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/", "hello"})
public class HelloController {

  @GetMapping
  public String hello() {
    return "hello";
  }
}
