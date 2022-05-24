package sep4package.Model;

import org.springframework.beans.factory.annotation.Autowired;

public class DataAccess
{
  @Autowired
  private ServiceFactory serviceFactory;
  private static DataAccess dataAccessInstance = null;

  public DataAccess()
  {
  }

  public static synchronized DataAccess dataAccess(){
    if(dataAccessInstance==null){
      dataAccessInstance = new DataAccess();
    }
    return dataAccessInstance;
  }

  public void setServicefactory(ServiceFactory serviceFactory){
    this.serviceFactory = serviceFactory;
  }

  public void addSensors(Sensors sensors)
  {
    serviceFactory.getSensorsService().addSensors(sensors);
  }

}
