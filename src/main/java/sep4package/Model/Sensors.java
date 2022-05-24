package sep4package.Model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import sep4package.Model.CO2.CO2Measurement;
import sep4package.Model.Humidity.HumidityMeasurement;
import sep4package.Model.Temperature.TemperatureMeasurement;

import javax.persistence.*;
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

    @OneToOne()
    @JoinColumn(name = "TemperatureId")
    private TemperatureMeasurement temperature;

    @OneToOne()
    @JoinColumn(name = "HumidityId")
    private HumidityMeasurement humidity;

    @OneToOne()
    @JoinColumn(name = "CO2Id")
    private CO2Measurement CO2;


    @Column
    private Timestamp Time;

    public Sensors(TemperatureMeasurement temperatureId, HumidityMeasurement humidityId, CO2Measurement Co2, Timestamp time) {
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

    public TemperatureMeasurement getTemperature() {
        return temperature;
    }

    public void setTemperature(TemperatureMeasurement temperatureId) {
        temperature = temperatureId;
    }

    public HumidityMeasurement getHumidity() {
        return humidity;
    }

    public void setHumidity(HumidityMeasurement humidityId) {
        humidity = humidityId;
    }

    public CO2Measurement getCO2() {
        return CO2;
    }

    public void setCO2(CO2Measurement co2) {
        this.CO2 = co2;
    }

    public Timestamp getTime() {
        return Time;
    }

    public void setTime(Timestamp time) {
        Time = time;
    }
}
