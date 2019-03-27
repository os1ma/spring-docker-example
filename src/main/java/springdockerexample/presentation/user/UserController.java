package springdockerexample.presentation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springdockerexample.application.service.UserService;
import springdockerexample.domain.user.Name;
import springdockerexample.domain.user.User;
import springdockerexample.domain.user.Users;

@RestController
@Validated
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping
  public FindAllResponse findAll() {
    Users users = userService.findAll();
    return FindAllResponse.from(users);
  }

  @GetMapping("/{name}")
  public FindByNameResponse findByName(@PathVariable String name) {
    User user = userService.findByName(new Name(name));
    return new FindByNameResponse(user);
  }
}