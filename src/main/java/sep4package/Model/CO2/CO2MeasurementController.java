package sep4package.Model.CO2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CO2MeasurementController
{
    @Autowired
    private final CO2MeasurementRepository repository;


    public CO2MeasurementController(CO2MeasurementRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/co2Sensors")
    List<CO2Measurement> all() {
        return repository.findAll();
    }

    @GetMapping("/co2Sensor/{id}")
    CO2Measurement one(@PathVariable java.lang.Long id) {
        return repository.findById(id).orElseThrow(
                () -> new CO2MeasurementNotFoundException(id)
        );
    }

//    @PutMapping("/projects/{pid}/employee/{eid}") CO2Sensor enrollEmployee(@PathVariable Long pid, @PathVariable Long eid) {
//        CO2Sensor project = repository.findById(pid).get();
//        TemperatureSensor employee = employeeRepository.findById(eid).get();
//        project.enrollEmployee(employee);
//        return repository.save(project);
//    }

    @PutMapping("/co2Sensor/{id}")
    CO2Measurement updateCO2Level(@RequestBody CO2Measurement newCO2Measurement, @PathVariable java.lang.Long id) {
        return repository.findById(id)
                .map(co2Sensor -> {
                    co2Sensor.setCO2Level(newCO2Measurement.getCO2Level());
                    return co2Sensor;
                })
                .orElseGet(() -> {
                    newCO2Measurement.setCO2Id(id);
                    return repository.save(newCO2Measurement);
                });
    }

    @PostMapping("/co2Sensor")
    CO2Measurement newCO2Sensor(@RequestBody CO2Measurement newCO2Measurement) {
        return repository.save(newCO2Measurement);
    }

    @DeleteMapping("/co2Sensors/{id}")
    void deleteSO2Sensor(@PathVariable java.lang.Long id) {
        repository.deleteById(id);
    }
}
