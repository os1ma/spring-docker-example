package springdockerexample.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Users {
  private List<User> users;

  public int count() {
    return users.size();
  }
}
