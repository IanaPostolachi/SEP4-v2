package sep4package;

import sep4package.LoraWanConnection.Service.WebSocketClient;
import sep4package.Model.CO2.CO2Sensor;
import sep4package.Model.Humidity.HumiditySensor;
import sep4package.Model.Humidity.HumiditySensorRepository;
import sep4package.Model.Sensors;
import sep4package.Model.SensorsRepository;
import sep4package.Model.Temperature.TemperatureSensor;
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

@Configuration public class LoadDatabase
{
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean CommandLineRunner initDatabase(
      TemperatureSensorRepository temperatureRepo, CO2SensorRepository co2Repo,
      HumiditySensorRepository humidityRepo,
      SensorsRepository sensorsRepository, WindowsRepository windowsRepository)
  {
    return args -> {
                  TemperatureSensor temperatureSensor = new TemperatureSensor(22);
                  HumiditySensor humiditySensor = new HumiditySensor(60);
                  CO2Sensor co2Sensor = new CO2Sensor(400);

      Windows window1 = new Windows(false,new Timestamp(2021,12,11,12,45,30,11));
      //            TemperatureSensor temperatureSensor1 = new TemperatureSensor(12);
      //            HumiditySensor humiditySensor1 = new HumiditySensor(6);
      //            CO2Sensor co2Sensor1 = new CO2Sensor(40);
      //
      //            TemperatureSensor temperatureSensor2 = new TemperatureSensor(2);
      //            HumiditySensor humiditySensor2 = new HumiditySensor(6);
      //            CO2Sensor co2Sensor2 = new CO2Sensor(4);
      //
                  Sensors sensors = new Sensors(temperatureSensor, humiditySensor , co2Sensor ,new Timestamp(2022,12,11,12,45,30,11));
      //            Sensors sensors1 = new Sensors(5 , temperatureSensor1 , humiditySensor1 , co2Sensor1 ,new Timestamp(2002,11,10,11,40,25,10));
      //            Sensors sensors2 = new Sensors(10 , temperatureSensor2 , humiditySensor2 , co2Sensor2 ,new Timestamp(2021,10,9,10,35,20,9));

      //
                  log.info("Preloading " + co2Repo.save(co2Sensor));
                  log.info("Preloading " + humidityRepo.save(humiditySensor));
                  log.info("Preloading " + temperatureRepo.save(temperatureSensor));
                  log.info("Preloading " + sensorsRepository.save(sensors));
                  log.info("Preloading " + windowsRepository.save(window1));
      //
      //            log.info("Preloading " + humidityRepo.save(humiditySensor1));
      //            log.info("Preloading " + temperatureRepo.save(temperatureSensor1));
      //            log.info("Preloading " + co2Repo.save(co2Sensor1));
      //            log.info("Preloading " + sensorsRepository.save(sensors1));
      //
      //            log.info("Preloading " + temperatureRepo.save(temperatureSensor2));
      //            log.info("Preloading " + co2Repo.save(co2Sensor2));
      //            log.info("Preloading " + humidityRepo.save(humiditySensor2));
      //            log.info("Preloading " + sensorsRepository.save(sensors2));
//
//      WebSocketClient wsc = new WebSocketClient();
//      Sensors sensors = wsc.getSensorsToDatabase();
//      log.info("Preloading " + sensorsRepository.save(sensors));
    };
  }
}

