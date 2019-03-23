package springdockerexample.infrastructure.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springdockerexample.domain.user.Name;
import springdockerexample.domain.user.User;

import java.util.List;

@Mapper
public interface UserMapper {

  List<User> selectAll();

  User selectByName(@Param("name") Name name);

}
