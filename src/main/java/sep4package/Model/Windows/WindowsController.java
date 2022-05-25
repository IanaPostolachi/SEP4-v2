package sep4package.Model.Windows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
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

  @GetMapping("/windows") List<Windows> all() {

    return repository.findAll();
  }

  @GetMapping("/window/{id}") Windows one(@PathVariable java.lang.Long id) {
    return repository.findById(id).orElseThrow(()
        -> new WindowNotFoundException(id));
  }

  @PostMapping("/newWindow") Windows newWindow(@RequestBody Windows newWindow) {
    repository.deleteAll();
    return repository.save(newWindow);
  }
}
