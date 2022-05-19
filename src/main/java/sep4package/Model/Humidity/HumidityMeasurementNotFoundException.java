package sep4package.Model.Humidity;

class HumidityMeasurementNotFoundException extends RuntimeException {
    HumidityMeasurementNotFoundException(Long id) {
        super("Could not find humidity sensor with id " + id);
    }
}
