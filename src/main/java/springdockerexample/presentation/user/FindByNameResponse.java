package springdockerexample.presentation.user;

import lombok.Data;
import springdockerexample.domain.user.User;

@Data
public class FindByNameResponse {
  private String name;
  private int age;

  public FindByNameResponse(User user) {
    this.name = user.getName().getValue();
    this.age = user.getAge().getValue();
  }
}
