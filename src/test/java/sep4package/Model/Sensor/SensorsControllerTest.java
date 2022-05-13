package sep4package.Model.Sensor;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sep4package.Model.CO2.CO2Sensor;
import sep4package.Model.Humidity.HumiditySensor;
import sep4package.Model.Sensors;

import sep4package.Model.SensorsRepository;
import sep4package.Model.Temperature.TemperatureSensor;
import sep4package.WebapiSepApplication;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebapiSepApplication.class)
class SensorsControllerTest
{
    @Autowired
    private SensorsRepository repository;

    @Test void all()
    {
        TemperatureSensor temperatureSensor = new TemperatureSensor(22);
        HumiditySensor humiditySensor = new HumiditySensor(60);
        CO2Sensor co2Sensor = new CO2Sensor(400);

        Sensors sensors = new Sensors(temperatureSensor, humiditySensor , co2Sensor ,new Timestamp(2022,12,11,12,45,30,11));
        Sensors sensor = repository.save(sensors);

        Sensors foundSensor = repository.findById(sensor.getSensorId()).orElse(null);

        assertNotNull(foundSensor);
        assertEquals(sensor.getSensorId(), foundSensor.getSensorId());

    }
}