package sep4package.Model.Temperature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureSensorRepository extends JpaRepository<TemperatureMeasurement, java.lang.Long> {
}
