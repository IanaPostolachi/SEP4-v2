package sep4package.LoraWanConnection.Network;


public class NetworkPackage {
  private String Sensors = "Sensors";
  private Object object;

  public NetworkPackage(String type, Object object) {
    Sensors = type;
    this.object = object;
  }

  public String getType() {
    return Sensors;
  }


  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }
}
