package sep4package.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

public class SensorsController
{
    private SensorsRepositoy repository;

    public SensorsController(SensorsRepositoy repository) {
        this.repository = repository;
    }

    @GetMapping("/sensors")
    List<Sensors> all() {
       return repository.findAll();
    }

    @GetMapping("/humiditySensor/{id}")
    Sensors one(@PathVariable java.lang.Long id) {
        return repository.findById(id).orElseThrow(
                () -> new SensorsNotFoundException(id)
        );
    }



}
