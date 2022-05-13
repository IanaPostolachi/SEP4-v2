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
    private long SensorId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TemperatureId")
    private TemperatureSensor temperature;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HumidityId")
    private HumiditySensor humidity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CO2Id")
    private CO2Sensor CO2;


    @Column
    private Timestamp Time;

    public Sensors(TemperatureSensor temperatureId, HumiditySensor humidityId, CO2Sensor Co2, Timestamp time) {
        temperature = temperatureId;
        humidity = humidityId;
        this.CO2 = Co2;
        Time = time;
    }

    public Sensors() {
    }

    public long getSensorId() {
        return SensorId;
    }

    public void setSensorId(long sensorId) {
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

    public Timestamp getTime() {
        return Time;
    }

    public void setTime(Timestamp time) {
        Time = time;
    }
}
