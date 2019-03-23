package springdockerexample.presentation.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import springdockerexample.domain.user.User;
import springdockerexample.domain.user.Users;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class FindAllResponse {

  public static FindAllResponse from(Users users) {
    List<FindAllResponseUser> elements = users.getUsers().stream()
            .map(FindAllResponseUser::new)
            .collect(Collectors.toList());
    return new FindAllResponse(elements);
  }

  private List<FindAllResponseUser> users;

}

@Data
class FindAllResponseUser {

  private String name;
  private int age;

  public FindAllResponseUser(User user) {
    this.name = user.getName().getValue();
    this.age = user.getAge().getValue();
  }

}