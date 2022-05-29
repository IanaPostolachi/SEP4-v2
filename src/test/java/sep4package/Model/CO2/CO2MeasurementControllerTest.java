package sep4package.Model.CO2;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sep4package.Model.Windows.Windows;
import sep4package.Model.Windows.WindowsRepository;
import sep4package.WebapiSepApplication;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebapiSepApplication.class)
class CO2MeasurementControllerTest
{

    @Autowired
        private CO2SensorRepository repository;

        @Test
        void all() {
            CO2Measurement co2 = repository.save(new CO2Measurement(100 , new Timestamp(123456)));
            CO2Measurement foundCo2 = repository.findById(co2.getCO2Id()).orElse(null);

            assertNotNull(foundCo2);
            assertEquals(co2.getCO2Id(), foundCo2.getCO2Id());
        }
}