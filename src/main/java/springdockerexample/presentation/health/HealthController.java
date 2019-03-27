package springdockerexample.presentation.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdockerexample.application.service.HealthService;
import springdockerexample.domain.health.Health;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthController {

  @Autowired
  private HealthService healthService;

  @GetMapping
  public ResponseEntity<String> getHealth() {
    Health health = healthService.getHealth();

    HttpStatus status = health.isHealthy() ? HttpStatus.OK : HttpStatus.SERVICE_UNAVAILABLE;

    return new ResponseEntity<>(health.toString(), status);
  }

  @PostMapping
  public Map<String, Health> registHealth(@RequestParam boolean health) {
    Health h = healthService.updateHealth(Health.valueOf(health));
    Map<String, Health> response = new HashMap<>();
    response.put("health", h);
    return response;
  }
}
