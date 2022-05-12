package sep4package.Model.Windows;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sep4package.Model.Humidity.HumiditySensor;
import sep4package.Model.Sensors;

import java.util.List;

@RestController
public class WindowsController
{
  private final WindowsRepository repository;

  public WindowsController(WindowsRepository repository)
  {
    this.repository = repository;
  }

  @GetMapping("/windows") List<Windows> all() {

    return repository.findAll();
  }

  @PostMapping("/newWindow") Windows newWindow(@RequestBody Windows newWindow) {
    return repository.save(newWindow);
  }
}
