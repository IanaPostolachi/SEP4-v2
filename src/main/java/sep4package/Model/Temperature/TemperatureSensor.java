package sep4package.Model.Temperature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Temperature")
@Table(name = "temperature")
public class TemperatureSensor
{
    @Id
    @Column(updatable = false)
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
        name = "sequence-generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "temperature_sequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
    )
    @JsonIgnoreProperties("TemperatureId")
    private Long TemperatureId;
    @Column
    private double Temperature;
    @Column
    private Timestamp Time;


    TemperatureSensor() {
    }

    public TemperatureSensor(double Temperature,Timestamp Time)
    {
        this.Temperature = Temperature;
        this.Time = Time;
    }

    public Long getTemperatureId()
    {
        return TemperatureId;
    }

    public void setTemperatureId(Long temperatureId)
    {
        TemperatureId = temperatureId;
    }

    public double getTemperature()
    {
        return Temperature;
    }

    public void setTemperature(double temperature)
    {
        Temperature = temperature;
    }

    public Timestamp getTime()
    {
        return new Timestamp(System.currentTimeMillis());
    }

    public void setTime(Timestamp time)
    {
        Time = time;
    }
}
