package sep4package.Model.Windows;

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
class WindowsControllerTest
{
  @Autowired
  private WindowsRepository repository;

  @Test void all()
  {
    Windows window = repository.save(new Windows(true, new Timestamp(132546786)));
    Windows foundWindow = repository.findById(window.getWindowId()).orElse(null);

    assertNotNull(foundWindow);
    assertEquals(window.getWindowId(), foundWindow.getWindowId());

  }
}