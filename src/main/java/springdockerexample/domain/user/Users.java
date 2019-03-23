package springdockerexample.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Users {
  private List<User> users;
}
