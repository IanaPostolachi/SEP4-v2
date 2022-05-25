package sep4package.LoraWanConnection.Service;

import com.google.gson.Gson;
import sep4package.Model.CO2.CO2Measurement;
import sep4package.Model.Humidity.HumidityMeasurement;
import sep4package.Model.Sensors;
import sep4package.Model.Temperature.TemperatureMeasurement;
import sep4package.Model.Windows.Windows;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
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
    String co2String = new String();
    String humString = new String();
    String temString = new String();
    String winString = new String();
    String timeString = new String();
    String allString = new String();
    boolean windowStatus = false;
    Timestamp timestamp;

    String hexValCo2 = data.getData().substring(0, 4);
    co2Level = Integer.parseInt(hexValCo2, 16);
    co2String = "{\"co2Level\":\"" + co2Level + "\"}";
    sendPost("http://sep4v2-env.eba-asbxjuyz.eu-west-1.elasticbeanstalk.com/co2Sensor",co2String);

    String hexValTemp = data.getData().substring(4,8);
    temperature = Integer.parseInt(hexValTemp, 16);
    temString = "{\"temperature\":\""+ temperature + "\"}";
    sendPost("http://sep4v2-env.eba-asbxjuyz.eu-west-1.elasticbeanstalk.com/temperature",temString);

    String hexValHum = data.getData().substring(8,12);
    humidity = Integer.parseInt(hexValHum, 16);
    humString = "{\"humidity\":\"" + humidity + "\"}";
    sendPost("http://sep4v2-env.eba-asbxjuyz.eu-west-1.elasticbeanstalk.com/humiditySensor",humString);

//    String hexValWin = data.getData().substring(12,16);
//    if(hexValWin == "ff9c")
//    {
//      windowStatus = false;
//    }
//    else if(hexValWin == "0064")
//    {
//      windowStatus = true;
//    }
//    timestamp = new Timestamp(data.getTs());
//    winString = "{\"windowOpen\":\"" + windowStatus + "\",";
//    timeString = "\"timestamp\":\"" + timestamp + "\"}";
//    allString = winString + temString;
//    sendPost("http://sep4v2-env.eba-asbxjuyz.eu-west-1.elasticbeanstalk.com/newWindow",allString);


    //Sensors sensors = new Sensors(temperatureMeasurement, humidityMeasurement, co2Measurement,timestamp);

    //return sensors;
    return null;
  }

  public static void sendPost(String apiurl,String params){
    try{
      URL url = new URL(apiurl);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST");
      connection.setDoOutput(true);
      connection.setRequestProperty("Content-Type","application/json");
      connection.setRequestProperty("Accept", "application/json");
      String payload = params;
      // String payload = "{\"humidity\":\"29.9\"}";// This should be your json body i.e. {"Name" : "Mohsin"}
      byte[] out = payload.getBytes(StandardCharsets.UTF_8);
      OutputStream stream = connection.getOutputStream();
      stream.write(out);
      System.out.println(connection.getResponseCode() + " " + connection.getResponseMessage()); // THis is optional
      connection.disconnect();
    }catch (Exception e){
      System.out.println(e);
      System.out.println("Failed successfully");
    }
  }

}


