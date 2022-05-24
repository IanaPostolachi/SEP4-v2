package sep4package.Model;

public class SensorsService
{
    private final SensorsRepository repository;


    public SensorsService(SensorsRepository repository) {
        this.repository = repository;
    }

    public void addSensors(Sensors sensors)
    {
        repository.save(sensors);
    }


}
