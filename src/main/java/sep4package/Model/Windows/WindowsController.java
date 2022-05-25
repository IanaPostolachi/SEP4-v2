package sep4package.Model.Windows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class WindowsController
{
  @Autowired
  private final WindowsRepository repository;

  public WindowsController(WindowsRepository repository)
  {
    this.repository = repository;
  }

  @GetMapping("/windows/{id}") Optional<Windows> all(long id) {

    return repository.findById(id);
  }

  @PostMapping("/newWindow") Windows newWindow(@RequestBody Windows newWindow) {
    repository.deleteAll();
    return repository.save(newWindow);
  }
}
