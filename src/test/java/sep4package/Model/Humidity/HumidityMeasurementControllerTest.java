package sep4package.Model.Humidity;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sep4package.WebapiSepApplication;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebapiSepApplication.class)
class HumidityMeasurementControllerTest
{
    @Autowired
    private HumidityMeasurementRepository repository;

    @Test
    void all()
    {
        HumidityMeasurement humidity = repository.save(new HumidityMeasurement(120 , new Timestamp(1241241)));
        HumidityMeasurement foundHumidity = repository.findById(humidity.getHumidityId()).orElse(null);

        assertNotNull(foundHumidity);
        assertEquals(humidity.getHumidityId(), foundHumidity.getHumidityId());

    }
}