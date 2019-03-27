package springdockerexample.presentation.health;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthController {

  private boolean isHealthy = true;

  @GetMapping
  public ResponseEntity<String> getHealth() {
    if (isHealthy) {
      return new ResponseEntity<>("healthy", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("unhealthy", HttpStatus.SERVICE_UNAVAILABLE);
    }
  }

  @PostMapping
  public Map<String, Boolean> registHealth(@RequestParam boolean health) {
    this.isHealthy = health;
    Map<String, Boolean> response = new HashMap<>();
    response.put("health", this.isHealthy);
    return response;
  }
}
