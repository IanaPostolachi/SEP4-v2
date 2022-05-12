package sep4package.Model.Window;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity(name = "Window")
@Table(name = "window")
public class Window
{
  @Column
  public boolean isWindowOpen;
  @Column
  public Timestamp time;

  public boolean isWindowOpen() {
    return isWindowOpen;
  }

  public void setWindowOpen(boolean windowOpen) {
    isWindowOpen = windowOpen;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    time = time;
  }
}
