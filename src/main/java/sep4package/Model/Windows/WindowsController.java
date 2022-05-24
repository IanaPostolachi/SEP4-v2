package sep4package.Model.Windows;

import org.springframework.web.bind.annotation.*;

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
    repository.deleteAll();
    return repository.save(newWindow);
  }

  @DeleteMapping("/windows/{id}")public void deleteWindow(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
