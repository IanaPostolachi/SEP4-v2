package sep4package.Model.Temperature;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import sep4package.Model.Sensors;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.Timestamp;

@Entity(name = "Temperature")
@Table(name = "temperature")
public class TemperatureMeasurement
{
    @Id
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
   // @JsonIgnoreProperties("TemperatureId")
    private Long TemperatureId;
    @Column
    private double Temperature;

    @Column
    private Timestamp Time;

    @OneToOne(mappedBy = "temperature")
    private Sensors sensors;


  public TemperatureMeasurement() {
    }

  public TemperatureMeasurement(Long TemperatureId,double Temperature) {
    this.TemperatureId = TemperatureId;
    this.Temperature = Temperature;

  }

    public TemperatureMeasurement(double Temperature,Timestamp timestamp) {
        this.Temperature = Temperature;
        this.Time = timestamp;

    }

    public java.lang.Long getTemperatureId()
    {
        return TemperatureId;
    }

    public void setTemperatureId(java.lang.Long temperatureId)
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
    return Time;
  }

  public void setTime(Timestamp time)
  {
    Time = time;
  }



}
