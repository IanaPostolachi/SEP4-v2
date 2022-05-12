package sep4package.Model.Windows;

public class WindowNotFoundException extends RuntimeException
{
  WindowNotFoundException(Long id) {
    super("Could not find window with id " + id);
  }
}
