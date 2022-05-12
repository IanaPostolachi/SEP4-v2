package sep4package.Model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
class WebapiSepApplicationTest
{
  private final SensorsRepository repository;
  public WebapiSepApplicationTest(SensorsRepository repository)
  {
    this.repository = repository;
  }

  @Test
  void contextLoads() {
  }
}