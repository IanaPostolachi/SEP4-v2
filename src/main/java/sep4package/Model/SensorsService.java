package sep4package.Model;

public class SensorsService
{
    private SensorsRepository repository;
    private Sensors sensors;


    public SensorsService(Sensors sensors) {
        this.sensors = sensors;

    }

    public void addSensors()
    {
        repository.save(sensors);
    }


}
