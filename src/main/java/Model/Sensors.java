package Model;

import Model.Temperature.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Sensors") @Table(name = "sensors_data") public class Sensors
{
  @Id @Column(updatable = false) @GeneratedValue(generator = "sequence-generator") @GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
      @org.hibernate.annotations.Parameter(name = "sequence_name", value = "sensors_sequence"),
      @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
      @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}) private int SensorId;
  @Column
//  @JsonIgnoreProperties("TemperatureId")
//  @OneToOne(mappedBy = "TemperatureId")
  private Long TemperatureId;
  @Column
  //  @OneToOne(mappedBy = "HumidityId")
  private Long HumidityId;
  @Column
  //  @OneToOne(mappedBy = "CO2Id")
  private Long CO2Id;
  @Column private boolean IsLightOn;
  @Column private boolean IsWindowOpen;
  @Column private Timestamp Time;

  public int getSensorId()
  {
    return SensorId;
  }

  public void setSensorId(int sensorId)
  {
    SensorId = sensorId;
  }

  public Long getTemperatureId()
  {
    return TemperatureId;
  }

  public void setTemperatureId(Long temperatureId)
  {
    TemperatureId = temperatureId;
  }

  public Long getHumidityId()
  {
    return HumidityId;
  }

  public void setHumidityId(Long humidityId)
  {
    HumidityId = humidityId;
  }

  public Long getCO2Id()
  {
    return CO2Id;
  }

  public void setCO2Id(Long CO2Id)
  {
    this.CO2Id = CO2Id;
  }

  public boolean isLightOn()
  {
    return IsLightOn;
  }

  public void setLightOn(boolean lightOn)
  {
    IsLightOn = lightOn;
  }

  public boolean isWindowOpen()
  {
    return IsWindowOpen;
  }

  public void setWindowOpen(boolean windowOpen)
  {
    IsWindowOpen = windowOpen;
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
