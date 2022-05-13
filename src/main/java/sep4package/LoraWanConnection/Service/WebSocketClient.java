package sep4package.LoraWanConnection.Service;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import sep4package.Model.Sensors;
import sep4package.Model.SensorsRepository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class WebSocketClient implements WebSocket.Listener
{
  private WebSocket server = null;
  private Gson gson = new Gson();
  HexConverter hexConverter = new HexConverter();
  private SensorsRepository sensorsRepository;
  Sensors sensorsToDatabase;


  public WebSocket getServer()
  {
    return server;
  }

  public void sendDownLink(String jsonTelegram)
  {
    server.sendText(jsonTelegram,true);
  }

  public WebSocketClient(String url) {
    HttpClient client = HttpClient.newHttpClient();
    CompletableFuture<WebSocket> ws = client.newWebSocketBuilder()
        .buildAsync(URI.create(url), this);

    server = ws.join();
  }
  public void onOpen(WebSocket webSocket) {

    //onOpen()
    // This WebSocket will invoke onText, onBinary, onPing, onPong or onClose methods on the associated listener (i.e. receive methods) up to n more times
    webSocket.request(1);
    System.out.println("WebSocket Listener has been opened for requests.");
  }

  //onError()
  public void onError(WebSocket webSocket, Throwable error) {
    System.out.println("A " + error.getCause() + " exception was thrown.");
    System.out.println("Message: " + error.getLocalizedMessage());
    webSocket.abort();
  }

  //onClose()
  public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
    System.out.println("WebSocket closed!");
    System.out.println("Status:" + statusCode + " Reason: " + reason);
    return new CompletableFuture().completedFuture("onClose() completed.").thenAccept(System.out::println);
  }

  //onPing()
  public CompletionStage<?> onPing(WebSocket webSocket, ByteBuffer message) {
    webSocket.request(1);
    System.out.println("Ping: Client ---> Server");
    System.out.println(message.asCharBuffer().toString());
    return new CompletableFuture().completedFuture("Ping completed.").thenAccept(System.out::println);
  }

  //onPong()
  public CompletionStage<?> onPong(WebSocket webSocket, ByteBuffer message) {
    webSocket.request(1);
    System.out.println("Pong: Client ---> Server");
    System.out.println(message.asCharBuffer().toString());
    return new CompletableFuture().completedFuture("Pong completed.").thenAccept(System.out::println);
  }

  //onText()
  public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
    String indented = null;
    try
    {
      indented = (new JSONObject(data.toString())).toString(4);
      UpLinkDataMessage upLinkDataMessage = gson.fromJson(indented,UpLinkDataMessage.class);
      sensorsToDatabase = hexConverter.convertFromHexToInt(upLinkDataMessage);
      sensorsRepository.save(sensorsToDatabase);
    }
    catch (JSONException e)
    {
      e.printStackTrace();
    }
    System.out.println(indented + sensorsToDatabase.getTemperature().getTemperature());
    webSocket.request(1);
    return new CompletableFuture().completedFuture("onText() completed.").thenAccept(System.out::println);
  };
}
