package springdockerexample.infrastructure.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import springdockerexample.domain.user.UserRepository;
import springdockerexample.domain.user.Users;
import springdockerexample.testhelper.MySQLContainerContextInitializer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = { MySQLContainerContextInitializer.class })
public class UserRepositoryImplTest {

  @Autowired
  UserRepository userRepository;

  @Test
  public void test() {
    Users users = userRepository.findAll();
    assertThat(users.count(), is(2));
  }
}
