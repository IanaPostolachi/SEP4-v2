package sep4package.Model.Windows;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Windows")
@Table(name = "windows")
public class Windows
{
  @Id
  @Column(updatable = false)
  @GeneratedValue(generator = "sequence-generator")
  @GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
      @org.hibernate.annotations.Parameter(name = "sequence_name", value = "windows_sequence"),
      @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
      @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")})
  private Long windowId;

  @Column
  private boolean isWindowOpen;

  @Column
  private Timestamp timestamp;

  public Windows(boolean isWindowOpen, Timestamp timestamp)
  {
    this.isWindowOpen = isWindowOpen;
    this.timestamp = timestamp;
  }

  public Windows()
  {

  }

  public boolean isWindowOpen()
  {
    return isWindowOpen;
  }

  public void setWindowOpen(boolean windowOpen)
  {
    isWindowOpen = windowOpen;
  }

  public Timestamp getTimestamp()
  {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp)
  {
    this.timestamp = timestamp;
  }

  public Long getWindowId()
  {
    return windowId;
  }

  public void setWindowId(Long windowId)
  {
    this.windowId = windowId;
  }
}
