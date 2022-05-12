package sep4package.Model.Window;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sep4package.Model.CO2.CO2Sensor;
import sep4package.Model.Humidity.HumiditySensor;
import sep4package.Model.Sensors;
import sep4package.Model.Temperature.TemperatureSensor;
import sep4package.Model.Windows.WindowsRepository;
import sep4package.WebapiSepApplication;

import java.sql.Timestamp;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebapiSepApplication.class)
class WindowControllerTest
{
  @Autowired
  WindowsRepository repository;

  @Test void all()
  {
//    Window window = new Window(false,new Timestamp(System.currentTimeMillis()));
//    repository.save(window);
//
//    Window window1 = repository.findById(window.getWindowId()).orElse(null);
//    assertNull(window1);
//
//    assertEquals(window.getWindowId(),window1.getWindowId());
  }

  @Test void newTemperature()
  {
  }
}