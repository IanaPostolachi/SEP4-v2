package sep4package.LoraWanConnection.Network;

/**
 * The type Network package.
 */
public class NetworkPackage {
  private String Sensors = "Sensors";
  private Object object;

  /**
   * Instantiates a new Network package.
   *
   * @param type   the type
   * @param object the object
   */
  public NetworkPackage(String type, Object object) {
    Sensors = type;
    this.object = object;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public String getType() {
    return Sensors;
  }

  /**
   * Gets object.
   *
   * @return the object
   */
  public Object getObject() {
    return object;
  }

  /**
   * Sets object.
   *
   * @param object the object
   */
  public void setObject(Object object) {
    this.object = object;
  }
}
