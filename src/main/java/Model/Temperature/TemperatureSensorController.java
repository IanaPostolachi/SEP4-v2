package Model.Temperature;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TemperatureSensorController
{

    private final TemperatureSensorRepository repository;

    TemperatureSensorController(TemperatureSensorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/temperatures")
    List<TemperatureSensor> all() {
        return repository.findAll();
    }

    @PostMapping("/temperature") TemperatureSensor newTemperature(@RequestBody TemperatureSensor newTemperature) {
        return repository.save(newTemperature);
    }

    @GetMapping("/temperature/{id}") TemperatureSensor one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(()
        -> new TemperatureSensorNotFoundException(id));
    }

    @PutMapping("/temperatures/{id}") TemperatureSensor updateTemperature(@RequestBody TemperatureSensor newTemperature, @PathVariable Long id) {
        return repository.findById(id)
                .map(temperature -> {
                    temperature.setTemperature(newTemperature.getTemperature());
                    return repository.save(temperature);
                })
                .orElseGet(() -> {
                    newTemperature.setTemperatureId(id);
                    return repository.save(newTemperature);
                });
    }

    @DeleteMapping("temperatures/{id}")
    void deleteTemperature(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
