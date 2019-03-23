package springdockerexample.domain.user;

public interface UserRepository {
  Users findAll();
  User findByName(Name name);
}
