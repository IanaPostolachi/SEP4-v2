package sep4package.Model.CO2;

class CO2MeasurementNotFoundException extends RuntimeException {
    CO2MeasurementNotFoundException(Long id) {
        super("Could not find CO2 sensor with id " + id);
    }
}
