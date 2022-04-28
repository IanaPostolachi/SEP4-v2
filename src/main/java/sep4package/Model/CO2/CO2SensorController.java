package sep4package.Model.CO2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CO2SensorController
{

    private final CO2SensorRepository repository;


    public CO2SensorController(CO2SensorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/co2Sensors")
    List<CO2Sensor> all() {
        return repository.findAll();
    }

    @GetMapping("/co2Sensor/{id}")
    CO2Sensor one(@PathVariable java.lang.Long id) {
        return repository.findById(id).orElseThrow(
                () -> new CO2SensorNotFoundException(id)
        );
    }

//    @PutMapping("/projects/{pid}/employee/{eid}") CO2Sensor enrollEmployee(@PathVariable Long pid, @PathVariable Long eid) {
//        CO2Sensor project = repository.findById(pid).get();
//        TemperatureSensor employee = employeeRepository.findById(eid).get();
//        project.enrollEmployee(employee);
//        return repository.save(project);
//    }

    @PutMapping("/co2Sensor/{id}")
    CO2Sensor updateCO2Level(@RequestBody CO2Sensor newCO2Sensor, @PathVariable java.lang.Long id) {
        return repository.findById(id)
                .map(co2Sensor -> {
                    co2Sensor.setCO2Level(newCO2Sensor.getCO2Level());
                    co2Sensor.setTime(newCO2Sensor.getTime());
                    return co2Sensor;
                })
                .orElseGet(() -> {
                    newCO2Sensor.setCO2Id(id);
                    return repository.save(newCO2Sensor);
                });
    }

    @PostMapping("/co2Sensor")
    CO2Sensor newCO2Sensor(@RequestBody CO2Sensor newCO2Sensor) {
        return repository.save(newCO2Sensor);
    }

    @DeleteMapping("/co2Sensors/{id}")
    void deleteSO2Sensor(@PathVariable java.lang.Long id) {
        repository.deleteById(id);
    }
}
