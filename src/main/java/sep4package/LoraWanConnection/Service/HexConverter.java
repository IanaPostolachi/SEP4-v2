package sep4package.LoraWanConnection.Service;

import org.apache.tomcat.jni.Time;
import sep4package.Model.CO2.CO2Sensor;
import sep4package.Model.Humidity.HumiditySensor;
import sep4package.Model.Sensors;
import sep4package.Model.Temperature.TemperatureSensor;

import java.sql.Timestamp;

public class HexConverter
{
  private String data;

  public HexConverter(String data)
  {
    this.data = data;
  }

  public HexConverter()
  {

  }

  public Sensors convertFromHexToInt(UpLinkDataMessage data)
  {
    int co2Level;
    int temperature;
    int humidity;
    Timestamp timestamp;

    String hexValCo2 = data.getData().substring(0, 4);
    co2Level = Integer.parseInt(hexValCo2, 16);
    CO2Sensor co2Sensor = new CO2Sensor(co2Level);

    String hexValTemp = data.getData().substring(4,8);
    temperature = Integer.parseInt(hexValTemp, 16);
    TemperatureSensor temperatureSensor = new TemperatureSensor(temperature);

    String hexValHum = data.getData().substring(8,12);
    humidity = Integer.parseInt(hexValHum, 16);
    HumiditySensor humiditySensor = new HumiditySensor(humidity);

    timestamp = new Timestamp(data.getTs());

    Sensors sensors = new Sensors(temperatureSensor,humiditySensor,co2Sensor,timestamp);

    return sensors;
  }
}
