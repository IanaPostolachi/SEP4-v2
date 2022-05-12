package sep4package.Model.Window;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Window")
@Table(name = "window")
public class Window
{
  @Id
  @Column(updatable = false)
  @GeneratedValue(generator = "sequence-generator")
  @GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
      @org.hibernate.annotations.Parameter(name = "sequence_name", value = "window_sequence"),
      @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
      @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
  private int WindowId;
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
