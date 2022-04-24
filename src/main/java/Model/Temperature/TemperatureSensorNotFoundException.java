package Model.Temperature;

class TemperatureSensorNotFoundException extends RuntimeException {
    TemperatureSensorNotFoundException(Long id) {
        super("Could not find temperature sensor with id " + id);
    }
}
