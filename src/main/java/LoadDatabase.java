import Model.CO2.CO2Sensor;
import Model.Humidity.HumiditySensor;
import Model.Humidity.HumiditySensorRepository;
import Model.Sensors;
import Model.Temperature.TemperatureSensor;
import Model.Temperature.TemperatureSensorRepository;
import Model.CO2.CO2SensorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TemperatureSensorRepository temperatureRepo, CO2SensorRepository co2Repo, HumiditySensorRepository humidityRepo) {
        return args -> {
            TemperatureSensor temperatureSensor = new TemperatureSensor( 22,new Timestamp(2022,12,11,12,45,30,11));
            HumiditySensor humiditySensor = new HumiditySensor( 60,new Timestamp(2022,12,11,12,45,30,11));
            CO2Sensor co2Sensor = new CO2Sensor( 400,new Timestamp(2022,12,11,12,45,30,11));
            Sensors sensors = new Sensors();
            log.info("Preloading " + temperatureRepo.save(temperatureSensor));
            log.info("Preloading " + co2Repo.save(co2Sensor));
            log.info("Preloading " + humidityRepo.save(humiditySensor));
        };
    }
}
