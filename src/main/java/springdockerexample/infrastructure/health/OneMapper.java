package springdockerexample.infrastructure.health;

import org.apache.ibatis.annotations.Mapper;
import springdockerexample.domain.health.One;

@Mapper
interface OneMapper {
  One selectOne();
}
