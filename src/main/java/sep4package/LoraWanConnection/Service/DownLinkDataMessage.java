package sep4package.LoraWanConnection.Service;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DownLinkDataMessage
{
  @JsonProperty
  private final String cmd = "tx";
  @JsonProperty
  private final String EUI = "0004A30B00F398F2";
  @JsonProperty
  private final int port = 2;
  @JsonProperty
  private boolean ack;
  @JsonProperty
  private String data;

  public DownLinkDataMessage(String data) {
    this.data = data;
  }

  public String getCmd()
  {
    return cmd;
  }

  public String getEUI()
  {
    return EUI;
  }

  public int getPort()
  {
    return port;
  }

  public boolean isAck()
  {
    return ack;
  }

  public void setAck(boolean ack)
  {
    this.ack = ack;
  }

  public String getData()
  {
    return data;
  }

  public void setData(String data)
  {
    this.data = data;
  }

}
