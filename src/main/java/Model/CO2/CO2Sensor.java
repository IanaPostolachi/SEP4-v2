package Model.CO2;

import Model.Temperature.TemperatureSensor;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "CO2")
@Table(name = "co2")
public class CO2Sensor
{

    @Id
    @Column(updatable = false)
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
        name = "sequence-generator",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "co2_sequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
        }
    )
    private Long CO2Id;
    @Column
    private int CO2Level;
    @Column
    private Timestamp Time;

    public CO2Sensor(int CO2Level, Timestamp timestamp) {
        this.CO2Level = CO2Level;
        this.Time = timestamp;
    }

    public CO2Sensor() {
    }

    public Long getCO2Id()
    {
        return CO2Id;
    }

    public void setCO2Id(Long CO2Id)
    {
        this.CO2Id = CO2Id;
    }

    public int getCO2Level()
    {
        return CO2Level;
    }

    public void setCO2Level(int CO2Level)
    {
        this.CO2Level = CO2Level;
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
