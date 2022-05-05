package sep4package.LoraWanConnection.ClientConnection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectionManager implements ConnectionHandler
{
  public static final String HOST = "localhost";

  public static final int PORT = 5432;
  private Socket socket;
  private DataInputStream inputStream;
  private DataOutputStream outputStream;
  private static ConnectionManager instance;

  private static Object lock = new Object();

  private ConnectionManager() throws IOException {
    connect();
  }

  public static ConnectionManager getInstance() throws IOException {
    if (instance == null) {
      synchronized (lock) {
        if (instance == null) {
          instance = new ConnectionManager();
        }
      }
    }
    return instance;
  }

  @Override public void connect() throws IOException
  {
    this.socket = new Socket(HOST, PORT);
    inputStream = new DataInputStream(socket.getInputStream());
    outputStream = new DataOutputStream(socket.getOutputStream());
  }

  @Override public void disconnect() throws IOException
  {
    socket.close();
  }

  @Override public void sendToServer(String message) throws IOException
  {
    byte[] toSendBytes = message.getBytes();
    int toSendLen = toSendBytes.length;
    byte[] toSendLenBytes = new byte[4];
    toSendLenBytes[0] = (byte) (toSendLen & 0xff);
    outputStream.write(toSendLenBytes);
    outputStream.write(toSendBytes);
  }

  @Override public String readFromServer() throws IOException
  {
    byte[] lenBytes = new byte[4];
    inputStream.readFully(lenBytes, 0, 4);
    int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
        ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
    byte[] receivedBytes = new byte[len];
    inputStream.readFully(receivedBytes, 0, len);

    System.out.println(inputStream +"received"+ receivedBytes + "----------error");
    return new String(receivedBytes, 0, len);
  }
}
