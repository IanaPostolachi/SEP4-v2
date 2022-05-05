package sep4package;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sep4package.LoraWanConnection.ClientConnection.ClientHandler;
import sep4package.LoraWanConnection.ClientConnection.ConnectionHandler;
import sep4package.LoraWanConnection.ClientConnection.ConnectionManager;
import sep4package.LoraWanConnection.Network.NetworkPackage;
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
		WebSocketClient websocketClient = new WebSocketClient("wss://iotnet.teracom.dk/app?token=vnoUgwAAABFpb3RuZXQudGVyYWNvbS5ka-scwzPaa30T3gTw3hGn_3I=");

		Gson gson = new Gson();

		ClientHandler clientHandler = new ClientHandler(websocketClient);

		Thread t = new Thread(clientHandler);
		t.setDaemon(true);
		t.start();

		while (true) {
			try {
				//                Only Needed To Mock Values
				//                sendRandomValues(gson);

				Thread.sleep(300000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void sendRandomValues(Gson gson) throws IOException {
		Sensors Sensors = new Sensors();

		TemperatureSensor temperatureSensortest = new TemperatureSensor(2);
		HumiditySensor humiditySensortest = new HumiditySensor(6);
		CO2Sensor co2Sensortest = new CO2Sensor(4);

		Sensors sensors = new Sensors(3 , temperatureSensortest, humiditySensortest , co2Sensortest ,new Timestamp(122,1,11,12,45,30,11));
		System.out.println(sensors.toString());
		ConnectionHandler handler = ConnectionManager.getInstance();
		NetworkPackage networkPackage = new NetworkPackage("Sensors", sensors);
		String gsonToServer = gson.toJson(networkPackage);
		handler.sendToServer(gsonToServer);
	}
	}

