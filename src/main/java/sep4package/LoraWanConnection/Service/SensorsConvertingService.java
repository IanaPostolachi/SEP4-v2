package sep4package.LoraWanConnection.Service;

import com.google.gson.Gson;
import sep4package.LoraWanConnection.ClientConnection.ConnectionHandler;
import sep4package.LoraWanConnection.ClientConnection.ConnectionManager;
import sep4package.LoraWanConnection.Network.NetworkPackage;
import sep4package.Model.CO2.CO2Sensor;
import sep4package.Model.Humidity.HumiditySensor;
import sep4package.Model.Sensors;
import sep4package.Model.Temperature.TemperatureSensor;

import java.io.IOException;
import java.sql.Timestamp;

public class SensorsConvertingService
{
  private Sensors sensors;

  public SensorsConvertingService()
  {
  }

  public void convertAndSend(UpLinkDataMessage upLinkDataMessage) {

    TemperatureSensor temperatureSensor = new TemperatureSensor(22);
    HumiditySensor humiditySensor = new HumiditySensor(60);
    CO2Sensor co2Sensor = new CO2Sensor(400);

    Sensors sensors = new Sensors(1 , temperatureSensor, humiditySensor , co2Sensor ,new Timestamp(2022,12,11,12,45,30,11));

    long timestamp = upLinkDataMessage.getTs();

//    hexVal = upLinkDataMessage.getData().substring(0, 4);
//    SensorHistory co2Sensor = new SensorHistory(CO2_SENSORS[room], timestamp, decVal);
//    System.out.println(co2Sensor.toString());

    Gson gson = new Gson();

    try {
      ConnectionHandler handler = ConnectionManager.getInstance();
      NetworkPackage networkPackage = new NetworkPackage("Sensors", sensors);
      String gsonToServer = gson.toJson(networkPackage);
      handler.sendToServer(gsonToServer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
