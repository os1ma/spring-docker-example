package springdockerexample.testhelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;

public class MySQLContainerContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

  /**
   * MySQL のイメージ名
   *
   * MySQL 8.0.15 は現在 testcontainers で利用できないため、5.7.25 を使用
   *
   * @see https://github.com/testcontainers/testcontainers-java/issues/736
   */
  private static final String MYSQL_IMAGE = "mysql:5.7.25";

  private static final String DATABASE_NAME = "mydb";
  private static final String USERNAME = "user";
  private static final String PASSWORD = "password";
  private static final int PORT = 3306;

  private static final String INIT_SQL = "docker-entrypoint-initdb.d/init.sql";
  private static final String INIT_SQL_IN_CONTAINER = "/docker-entrypoint-initdb.d/init.sql";

  private static final Logger LOGGER = LoggerFactory.getLogger(MySQLContainerContextInitializer.class);

  private static final MySQLContainer MYSQL = (MySQLContainer) new MySQLContainer(MYSQL_IMAGE)
          .withDatabaseName(DATABASE_NAME)
          .withUsername(USERNAME)
          .withPassword(PASSWORD)
          .withExposedPorts(PORT)
          .withLogConsumer(new Slf4jLogConsumer(LOGGER))
          .withClasspathResourceMapping(INIT_SQL, INIT_SQL_IN_CONTAINER, BindMode.READ_ONLY);

  static  {
    MYSQL.start();
  }

  @Override
  public void initialize(ConfigurableApplicationContext context) {
    MYSQL.start();
    String mysqlJdbcUrl = MYSQL.getJdbcUrl() +
            "?spring.datasource.username=" + MYSQL.getUsername() +
            "spring.datasource.password=" + MYSQL.getPassword() +
            "spring.datasource.driver-class-name=" + MYSQL.getDriverClassName();
    TestPropertyValues.of("spring.datasource.url=" + mysqlJdbcUrl)
            .applyTo(context.getEnvironment());
  }
}
