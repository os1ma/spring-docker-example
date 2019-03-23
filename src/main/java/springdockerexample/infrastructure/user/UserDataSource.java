package springdockerexample.infrastructure.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springdockerexample.domain.user.Name;
import springdockerexample.domain.user.User;
import springdockerexample.domain.user.UserRepository;
import springdockerexample.domain.user.Users;

import java.util.List;

@Repository
public class UserDataSource implements UserRepository {
  @Autowired
  private UserMapper mapper;

  @Override
  public Users findAll() {
    List<User> users = mapper.selectAll();
    return new Users(users);
  }

  @Override
  public User findByName(Name name) {
    return mapper.selectByName(name);
  }
}
