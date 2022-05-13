package sep4package;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sep4package.LoraWanConnection.Service.WebSocketClient;
import sep4package.Model.CO2.CO2Sensor;
import sep4package.Model.Humidity.HumiditySensor;
import sep4package.Model.Sensors;
import sep4package.Model.Temperature.TemperatureSensor;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

@SpringBootApplication
public class WebapiSepApplication
{
	public static void main(String[] args) throws IOException
	{
		SpringApplication.run(WebapiSepApplication.class, args);
		WebSocketClient websocketClient = new WebSocketClient(
				"wss://iotnet.teracom.dk/app?token=vnoUgwAAABFpb3RuZXQudGVyYWNvbS5ka-scwzPaa30T3gTw3hGn_3I=");
	}
}

