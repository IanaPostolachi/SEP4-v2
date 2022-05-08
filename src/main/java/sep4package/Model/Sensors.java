package sep4package.Model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import sep4package.Model.CO2.CO2Sensor;
import sep4package.Model.Humidity.HumiditySensor;
import sep4package.Model.Temperature.TemperatureSensor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.Timestamp;

@Entity(name = "Sensors")
@Table(name = "sensors_data")
public class Sensors {
    @Id
    @Column(updatable = false)
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sensors_sequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
    private int SensorId;

    @OneToOne
    @JoinColumn(name = "TemperatureId")
    private TemperatureSensor temperature;

    @OneToOne
    @JoinColumn(name = "HumidityId")
    private HumiditySensor humidity;

    @OneToOne
    @JoinColumn(name = "CO2Id")
    private CO2Sensor CO2;

    @Column
    private boolean IsLightOn;
    @Column
    private boolean IsWindowOpen;

    @Column
    private Timestamp Time;

    public Sensors(int sensorId, TemperatureSensor temperatureId, HumiditySensor humidityId, CO2Sensor Co2, Timestamp time) {
        SensorId = sensorId;
        temperature = temperatureId;
        humidity = humidityId;
        this.CO2 = Co2;
        IsLightOn = false;
        IsWindowOpen = false;
        Time = time;
    }

    public Sensors() {
    }

    public int getSensorId() {
        return SensorId;
    }

    public void setSensorId(int sensorId) {
        SensorId = sensorId;
    }

    public TemperatureSensor getTemperature() {
        return temperature;
    }

    public void setTemperature(TemperatureSensor temperatureId) {
        temperature = temperatureId;
    }

    public HumiditySensor getHumidity() {
        return humidity;
    }

    public void setHumidity(HumiditySensor humidityId) {
        humidity = humidityId;
    }

    public CO2Sensor getCO2() {
        return CO2;
    }

    public void setCO2(CO2Sensor co2) {
        this.CO2 = co2;
    }

    public boolean isLightOn() {
        return IsLightOn;
    }

    public void setLightOn(boolean lightOn) {
        IsLightOn = lightOn;
    }

    public boolean isWindowOpen() {
        return IsWindowOpen;
    }

    public void setWindowOpen(boolean windowOpen) {
        IsWindowOpen = windowOpen;
    }

    public Timestamp getTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public void setTime(Timestamp time) {
        Time = time;
    }
}
