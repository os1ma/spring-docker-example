package springdockerexample.domain.health;

public enum  Health {
  HEALTHY,
  UNHEALTHY;

  public static Health valueOf(boolean healthy) {
    return healthy ? HEALTHY : UNHEALTHY;
  }

  public boolean isHealthy() {
    return this.equals(HEALTHY);
  }
}
