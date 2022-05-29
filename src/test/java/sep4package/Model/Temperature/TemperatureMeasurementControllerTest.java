package sep4package.Model.Temperature;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sep4package.WebapiSepApplication;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebapiSepApplication.class)
class TemperatureMeasurementControllerTest
{
    @Autowired
    private TemperatureSensorRepository repository;

    @Test
    void all()
    {
        TemperatureMeasurement temp = repository.save(new TemperatureMeasurement(21 , new Timestamp(1285743)));
        TemperatureMeasurement foundTemp = repository.findById(temp.getTemperatureId()).orElse(null);

        assertNotNull(foundTemp);
        assertEquals(temp.getTemperature(), foundTemp.getTemperature());

    }
}