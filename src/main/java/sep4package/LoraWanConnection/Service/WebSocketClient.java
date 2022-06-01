package sep4package.LoraWanConnection.Service;

import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import sep4package.Model.Windows.WindowStatus;
import java.io.IOException;
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

  //onOpen()
  public void onOpen(WebSocket webSocket) {
    // This WebSocket will invoke onText, onBinary, onPing, onPong or onClose methods on the associated listener (i.e. receive methods) up to n more times
    webSocket.request(1);
    System.out.println("WebSocket Listener has been opened for requests.");
  }

  //onError()
  public void onError(WebSocket webSocket, Throwable error) {
    System.out.println("A " + error.getCause() + " exception was thrown.");
    System.out.println("Message: " + error.getLocalizedMessage());
    //System.out.println(webSocket);
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
      hexConverter.convertFromHexToInt(upLinkDataMessage);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    try
    {
      sendData();
    }
    catch (JSONException | IOException e)
    {
      e.printStackTrace();
    }
    //System.out.println(indented);
    webSocket.request(1);
    try{
      Thread.sleep(300000);
    }catch (InterruptedException e){
      System.out.println("Thread interrupted");
    }
    return new CompletableFuture().completedFuture("onText() completed.").thenAccept(System.out::println);
  }

  public void sendData() throws IOException, JSONException
  {
    DownLinkDataMessage msg = new DownLinkDataMessage(WindowStatus.getStatus());
    //System.out.println(gson.toJson(msg));
    sendDownLink(gson.toJson(msg));
  }

}
