package Model.Temperature;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureSensorRepository extends JpaRepository<TemperatureSensor, Long> {
}
