package sep4package.LoraWanConnection.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class HexConverter {
    private String data;

    public HexConverter(String data) {
        this.data = data;
    }

    public HexConverter() {

    }

    public void convertFromHexToInt(UpLinkDataMessage data) {
        int co2Level = 0;
        int temperature = 0;
        int humidity = 0;

        String co2String;
        String humString;
        String temString;
        String winString;
        String timeString;
        String timestampString;
        String allString;
        boolean windowStatus = false;
        LocalDateTime timestamp;


        timestamp = new Timestamp(data.getTs()).toLocalDateTime();
        timestampString = "{\"timestamp\":\"" + timestamp + "\",";
        timeString ="{\"time\":\"" + timestamp + "\",";
        if (data.getData() != null) {
            if (data.getData().length() >= 12) {
                //System.out.println(data.getData());
                String hexValCo2 = data.getData().substring(0, 4);
                co2Level = Integer.parseInt(hexValCo2, 16);
                co2String = "\"co2Level\":\"" + co2Level + "\"}";
                String co2AllString = timeString + co2String;
                sendPost(
                        "http://sep4v2-env.eba-asbxjuyz.eu-west-1.elasticbeanstalk.com/co2Sensor",
                        co2AllString);

                String hexValTemp = data.getData().substring(4, 8);
                temperature = Integer.parseInt(hexValTemp, 16) / 10;
                temString = "\"temperature\":\"" + temperature + "\"}";
                String temAllString = timeString + temString;
                sendPost(
                        "http://sep4v2-env.eba-asbxjuyz.eu-west-1.elasticbeanstalk.com/temperature",
                        temAllString);

                String hexValHum = data.getData().substring(8, 12);
                humidity = Integer.parseInt(hexValHum, 16) / 10;
                humString = "\"humidity\":\"" + humidity + "\"}";
                String humAllString = timeString + humString;
                sendPost(
                        "http://sep4v2-env.eba-asbxjuyz.eu-west-1.elasticbeanstalk.com/humiditySensor",
                        humAllString);

                String hexValWin = data.getData().substring(12,16);
                if(hexValWin == "0000")
                {
                    windowStatus = false;
                }
                else if(hexValWin == "0064")
                {
                    windowStatus = true;
                }
                winString = "\"windowOpen\":\"" + windowStatus + "\"}";   //don't forget ,  and delete }
                allString = timestampString + winString;
                System.out.println("The window status we recived and save to database: " + allString);
                sendPost("http://sep4v2-env.eba-asbxjuyz.eu-west-1.elasticbeanstalk.com/newWindow",allString);
            }
        }
    }

    public static void sendPost(String apiurl, String payload) {
        try {
            URL url = new URL(apiurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            // String payload = "{\"humidity\":\"29.9\"}";// This should be your json body i.e. {"Name" : "Mohsin"}
            byte[] out = payload.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);
            System.out.println(connection.getResponseCode()); // This is optional
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Failed");
        }
    }

}


