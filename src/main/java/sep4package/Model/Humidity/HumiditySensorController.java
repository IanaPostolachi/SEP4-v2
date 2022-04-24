package sep4package.Model.Humidity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HumiditySensorController
{

    private final HumiditySensorRepository repository;


    public HumiditySensorController(HumiditySensorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/humiditySensors")
    List<HumiditySensor> all() {
        return repository.findAll();
    }

    @GetMapping("/humiditySensor/{id}") HumiditySensor one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(
                () -> new HumiditySensorNotFoundException(id)
        );
    }

//    @PutMapping("/projects/{pid}/employee/{eid}") CO2Sensor enrollEmployee(@PathVariable Long pid, @PathVariable Long eid) {
//        CO2Sensor project = repository.findById(pid).get();
//        TemperatureSensor employee = employeeRepository.findById(eid).get();
//        project.enrollEmployee(employee);
//        return repository.save(project);
//    }

    @PutMapping("/humiditySensor/{id}") HumiditySensor updateHumidityLevel(@RequestBody HumiditySensor newHumiditySensor, @PathVariable Long id) {
        return repository.findById(id)
                .map(co2Sensor -> {
                    co2Sensor.setHumidity(newHumiditySensor.getHumidity());
                    co2Sensor.setTime(newHumiditySensor.getTime());
                    return co2Sensor;
                })
                .orElseGet(() -> {
                    newHumiditySensor.setHumidityId(id);
                    return repository.save(newHumiditySensor);
                });
    }

    @PostMapping("/humiditySensor") HumiditySensor newHumiditySensor(@RequestBody HumiditySensor newHumiditySensor) {
        return repository.save(newHumiditySensor);
    }

    @DeleteMapping("/humiditySensors/{id}")
    void deleteHumiditySensor(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
