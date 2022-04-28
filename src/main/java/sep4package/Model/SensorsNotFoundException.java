package sep4package.Model;

public class SensorsNotFoundException extends RuntimeException {
    public SensorsNotFoundException(Long id) {
        super("Could not find humidity sensor with id " + id);
    }
}
