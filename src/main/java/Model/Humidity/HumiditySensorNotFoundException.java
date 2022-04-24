package Model.Humidity;

class HumiditySensorNotFoundException extends RuntimeException {
    HumiditySensorNotFoundException(Long id) {
        super("Could not find humidity sensor with id " + id);
    }
}
