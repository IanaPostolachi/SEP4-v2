package sep4package.Model;

import org.springframework.web.bind.annotation.GetMapping;
import sep4package.Model.Humidity.HumiditySensor;

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

    

}
