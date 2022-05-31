package sep4package.Model.CO2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface CO2MeasurementRepository extends JpaRepository<CO2Measurement, java.lang.Long> {
}
