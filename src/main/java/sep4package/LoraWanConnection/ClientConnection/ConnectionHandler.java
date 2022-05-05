package sep4package.LoraWanConnection.ClientConnection;

import java.io.IOException;

public interface ConnectionHandler
{

  void connect() throws IOException;


  void disconnect() throws IOException;


  void sendToServer(String message) throws IOException;


  String readFromServer() throws IOException;
}
