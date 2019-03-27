package springdockerexample.infrastructure.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springdockerexample.domain.health.OneRepository;
import springdockerexample.domain.health.One;

@Repository
public class OneRepositoryImpl implements OneRepository {
  @Autowired
  private OneMapper mapper;

  @Override
  public One selectOne() {
    return mapper.selectOne();
  }
}
