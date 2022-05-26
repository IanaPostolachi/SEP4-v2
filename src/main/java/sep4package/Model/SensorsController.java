package sep4package.Model;


import org.springframework.web.bind.annotation.*;
import sep4package.Model.Windows.Windows;

import java.util.List;

@RestController
public class SensorsController
{

    private final SensorsRepository repository;

    public SensorsController(SensorsRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/sensors") List<Sensors> all()
    {
        return repository.findAll();
    }

    @GetMapping("/sensors/{id}") Sensors one(@PathVariable java.lang.Long id)
    {
        return repository.findById(id).orElseThrow(() -> new SensorsNotFoundException(id));
    }

    @PostMapping("/newSensors") Sensors newSensor(@RequestBody Sensors newSensor)
    {
        return repository.save(newSensor);
    }
}
