package springdockerexample.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdockerexample.domain.health.Health;
import springdockerexample.domain.health.OneRepository;

@Service
public class HealthService {
  @Autowired
  private OneRepository oneRepository;

  private Health health = Health.HEALTHY;

  public Health getHealth() {
    // Try executing query 'SELECT 1'.
    oneRepository.selectOne();

    return this.health;
  }

  public Health updateHealth(Health health) {
    return this.health = health;
  }
}
