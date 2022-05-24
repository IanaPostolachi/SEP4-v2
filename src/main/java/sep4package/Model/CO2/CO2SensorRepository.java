package sep4package.Model.CO2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CO2SensorRepository extends JpaRepository<CO2Measurement, java.lang.Long> {
}
