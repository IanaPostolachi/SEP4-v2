package sep4package.Model.Humidity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HumidityMeasurementController
{
    @Autowired
    private final HumiditySensorRepository repository;


    public HumidityMeasurementController(HumiditySensorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/humiditySensors")
    List<HumidityMeasurement> all() {
        return repository.findAll();
    }

    @GetMapping("/humiditySensor/{id}")
    HumidityMeasurement one(@PathVariable java.lang.Long id) {
        return repository.findById(id).orElseThrow(
                () -> new HumidityMeasurementNotFoundException(id)
        );
    }

//    @PutMapping("/projects/{pid}/employee/{eid}") CO2Sensor enrollEmployee(@PathVariable Long pid, @PathVariable Long eid) {
//        CO2Sensor project = repository.findById(pid).get();
//        TemperatureSensor employee = employeeRepository.findById(eid).get();
//        project.enrollEmployee(employee);
//        return repository.save(project);
//    }

    @PutMapping("/humiditySensor/{id}")
    HumidityMeasurement updateHumidityLevel(@RequestBody HumidityMeasurement newHumidityMeasurement, @PathVariable java.lang.Long id) {
        return repository.findById(id)
                .map(co2Sensor -> {
                    co2Sensor.setHumidity(newHumidityMeasurement.getHumidity());
                    return co2Sensor;
                })
                .orElseGet(() -> {
                    newHumidityMeasurement.setHumidityId(id);
                    return repository.save(newHumidityMeasurement);
                });
    }

    @PostMapping("/humiditySensor")
    HumidityMeasurement newHumiditySensor(@RequestBody HumidityMeasurement newHumidityMeasurement) {
        return repository.save(newHumidityMeasurement);
    }

    @DeleteMapping("/humiditySensors/{id}")
    void deleteHumiditySensor(@PathVariable java.lang.Long id) {
        repository.deleteById(id);
    }
}
