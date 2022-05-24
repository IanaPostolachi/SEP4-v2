package sep4package.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SensorsRepository extends JpaRepository<Sensors , Long>
{

}
