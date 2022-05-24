package sep4package.LoraWanConnection.Service;

import sep4package.Model.CO2.CO2Measurement;
import sep4package.Model.Humidity.HumidityMeasurement;
import sep4package.Model.Sensors;
import sep4package.Model.Temperature.TemperatureMeasurement;
import sep4package.Model.Windows.Windows;

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
    boolean windowStatus = false;
    Timestamp timestamp;

    String hexValCo2 = data.getData().substring(0, 4);
    co2Level = Integer.parseInt(hexValCo2, 16);
    CO2Measurement co2Measurement = new CO2Measurement(co2Level);

    String hexValTemp = data.getData().substring(4,8);
    temperature = Integer.parseInt(hexValTemp, 16);
    TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement(temperature);

    String hexValHum = data.getData().substring(8,12);
    humidity = Integer.parseInt(hexValHum, 16);
    HumidityMeasurement humidityMeasurement = new HumidityMeasurement(humidity);
    
    String hexValWin = data.getData().substring(12,16);
    if(hexValWin == "ff9c")
    {
      windowStatus = false;
    }
    else if(hexValWin == "0064")
    {
      windowStatus = true;
    }

    Windows windows = new Windows(windowStatus,new Timestamp(System.currentTimeMillis()));
    timestamp = new Timestamp(data.getTs());

    Sensors sensors = new Sensors(temperatureMeasurement, humidityMeasurement, co2Measurement,timestamp);

    return sensors;
  }
}


