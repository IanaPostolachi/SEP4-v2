package sep4package;

import sep4package.Model.Humidity.HumidityMeasurementRepository;
import sep4package.Model.SensorsRepository;
import sep4package.Model.Temperature.TemperatureMeasurementRepository;
import sep4package.Model.CO2.CO2MeasurementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sep4package.Model.Windows.WindowsRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(
            TemperatureMeasurementRepository temperatureRepo,
            CO2MeasurementRepository co2Repo,
            HumidityMeasurementRepository humidityRepo,
            SensorsRepository sensorsRepository,
            WindowsRepository windowsRepository) {
        return args -> {

     /*TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(
          22);
      HumidityMeasurement humidityMeasurement = new HumidityMeasurement(60,new Timestamp(122, 5, 27, 15, 51, 25, 10));
      CO2Measurement co2Measurement = new CO2Measurement(400,new Timestamp(122, 5, 27, 15, 51, 25, 10));

      TemperatureMeasurement temperatureMeasurement1 = new TemperatureMeasurement(
          18);
      HumidityMeasurement humidityMeasurement1 = new HumidityMeasurement(19,new Timestamp(122, 5, 27, 15, 51, 25, 10));
      CO2Measurement co2Measurement1 = new CO2Measurement(221,new Timestamp(122, 5, 27, 15, 51, 25, 10));

      TemperatureMeasurement temperatureMeasurement2 = new TemperatureMeasurement(
          18);
      HumidityMeasurement humidityMeasurement2 = new HumidityMeasurement(19,new Timestamp(122, 5, 27, 15, 51, 25, 10));
      CO2Measurement co2Measurement2 = new CO2Measurement(221,new Timestamp(122, 5, 27, 15, 51, 25, 10));

      Sensors sensors = new Sensors(temperatureMeasurement, humidityMeasurement,
          co2Measurement, new Timestamp(122, 5, 27, 15, 51, 25, 10));
      Sensors sensors1 = new Sensors(temperatureMeasurement1,
          humidityMeasurement1, co2Measurement1,
          new Timestamp(122, 5, 27, 15, 51, 25, 10));
      Sensors sensors2 = new Sensors(temperatureMeasurement2,
          humidityMeasurement2, co2Measurement2,
          new Timestamp(122, 5, 27, 15, 51, 25, 10));


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

            //Windows windows = new Windows(false,new Timestamp(System.currentTimeMillis()));
            //log.info("Preloading " + windowsRepository.save(windows));
        };
    }
}

