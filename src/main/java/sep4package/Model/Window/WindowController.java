package sep4package.Model.Window;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sep4package.Model.Temperature.TemperatureSensor;

import java.util.List;

@RestController
public class WindowController
{
  private final WindowRepository repository;

  public WindowController(WindowRepository repository)
  {
    this.repository = repository;
  }

  @GetMapping("/windows") List<Window> all() {
    return repository.findAll();
  }

  @PostMapping("/window")
  Window newTemperature(@RequestBody Window newWindow) {
    return repository.save(newWindow);
  }
}
