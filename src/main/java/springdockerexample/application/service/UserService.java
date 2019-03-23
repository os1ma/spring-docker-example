package springdockerexample.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdockerexample.domain.user.Name;
import springdockerexample.domain.user.User;
import springdockerexample.domain.user.UserRepository;
import springdockerexample.domain.user.Users;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public Users findAll() {
    return userRepository.findAll();
  }

  public User findByName(Name name) {
    return userRepository.findByName(name);
  }
}
