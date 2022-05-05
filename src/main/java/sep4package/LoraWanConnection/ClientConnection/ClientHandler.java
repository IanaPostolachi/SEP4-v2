package sep4package.LoraWanConnection.ClientConnection;

import com.google.gson.Gson;
import sep4package.LoraWanConnection.Service.DownLinkDataMessage;
import sep4package.LoraWanConnection.Service.WebSocketClient;
import sep4package.Model.Sensors;

import java.io.IOException;

public class ClientHandler implements Runnable
{
  private WebSocketClient websocketClient;
  private ConnectionHandler handler;
  private Gson gson;

  public ClientHandler(WebSocketClient websocketClient) throws IOException
  {
    this.websocketClient = websocketClient;
    this.handler = ConnectionManager.getInstance();
    this.gson = new Gson();
  }

  @Override public void run()
  {
    while (true)
    {
      try
      {
        // Reading a gson from server
        String dataFromServer = handler.readFromServer();

        System.out.println("-------error--------");
        // Converting the gson to NetworkPackage in order to get the type and value
        Sensors incomingSensorData = gson.fromJson(dataFromServer,
            Sensors.class);
        String integerAsHexString = Integer.toHexString(
            incomingSensorData.getCO2().getCO2Level());
        DownLinkDataMessage downLinkDataMessage = new DownLinkDataMessage(true,
            integerAsHexString);
        String downLinkPayload = gson.toJson(downLinkDataMessage,
            DownLinkDataMessage.class);
        System.out.println(downLinkPayload);
        //              websocketClient.sendDownLink(downLinkPayload);

      }
      catch (IOException e)
      {
        System.out.println("Couldn't process request");
      }
    }
  }
}
