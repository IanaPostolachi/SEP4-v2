package sep4package.Model.Temperature;

class TemperatureMeasurementNotFoundException extends RuntimeException {
    TemperatureMeasurementNotFoundException(Long id) {
        super("Could not find temperature sensor with id " + id);
    }
}
