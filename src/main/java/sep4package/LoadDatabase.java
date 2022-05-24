package sep4package;

import org.springframework.beans.factory.annotation.Autowired;
import sep4package.Model.CO2.CO2Measurement;
import sep4package.Model.Humidity.HumidityMeasurement;
import sep4package.Model.Humidity.HumiditySensorRepository;
import sep4package.Model.Sensors;
import sep4package.Model.SensorsRepository;
import sep4package.Model.Temperature.TemperatureMeasurement;
import sep4package.Model.Temperature.TemperatureSensorRepository;
import sep4package.Model.CO2.CO2SensorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sep4package.Model.Windows.Windows;
import sep4package.Model.Windows.WindowsRepository;

import java.sql.Timestamp;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
            @Autowired
            TemperatureSensorRepository temperatureRepo,
            @Autowired
            CO2SensorRepository co2Repo,
            @Autowired
            HumiditySensorRepository humidityRepo,
            @Autowired
            SensorsRepository sensorsRepository,
            @Autowired
            WindowsRepository windowsRepository) {
        return args -> {

/*      TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(
          22);
      HumidityMeasurement humidityMeasurement = new HumidityMeasurement(60);
      CO2Measurement co2Measurement = new CO2Measurement(400);

      TemperatureMeasurement temperatureMeasurement1 = new TemperatureMeasurement(
          18);
      HumidityMeasurement humidityMeasurement1 = new HumidityMeasurement(19);
      CO2Measurement co2Measurement1 = new CO2Measurement(221);

      TemperatureMeasurement temperatureMeasurement2 = new TemperatureMeasurement(
          18);
      HumidityMeasurement humidityMeasurement2 = new HumidityMeasurement(19);
      CO2Measurement co2Measurement2 = new CO2Measurement(221);

      Sensors sensors = new Sensors(temperatureMeasurement, humidityMeasurement,
          co2Measurement, new Timestamp(2022, 12, 11, 12, 45, 30, 11));
      Sensors sensors1 = new Sensors(temperatureMeasurement1,
          humidityMeasurement1, co2Measurement1,
          new Timestamp(2002, 11, 10, 11, 40, 25, 10));
      Sensors sensors2 = new Sensors(temperatureMeasurement2,
          humidityMeasurement2, co2Measurement2,
          new Timestamp(2021, 10, 9, 10, 35, 20, 9));

      log.info("Preloading " + co2Repo.save(co2Measurement));
      log.info("Preloading " + humidityRepo.save(humidityMeasurement));
      log.info("Preloading " + temperatureRepo.save(temperatureMeasurement));
      log.info("Preloading " + sensorsRepository.save(sensors));

      log.info("Preloading " + humidityRepo.save(humidityMeasurement1));
      log.info("Preloading " + temperatureRepo.save(temperatureMeasurement1));
      log.info("Preloading " + co2Repo.save(co2Measurement1));
      log.info("Preloading " + sensorsRepository.save(sensors1));

      log.info("Preloading " + temperatureRepo.save(temperatureMeasurement2));
      log.info("Preloading " + co2Repo.save(co2Measurement2));
      log.info("Preloading " + humidityRepo.save(humidityMeasurement2));
      log.info("Preloading " + sensorsRepository.save(sensors2));*/
        };
    }
}

