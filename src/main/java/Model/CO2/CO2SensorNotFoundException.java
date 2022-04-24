package Model.CO2;

class CO2SensorNotFoundException extends RuntimeException {
    CO2SensorNotFoundException(Long id) {
        super("Could not find CO2 sensor with id " + id);
    }
}
