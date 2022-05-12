package sep4package.Model.Window;

public class WindowNotFoundException extends RuntimeException
{
    WindowNotFoundException(Long id) {
      super("Could not find window with id " + id);
    }
  }
