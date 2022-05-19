package sep4package;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sep4package.LoraWanConnection.Service.WebSocketClient;

import java.io.IOException;

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

