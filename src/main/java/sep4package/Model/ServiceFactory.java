package sep4package.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory
{
  private SensorsService sensorsService;
  private SensorsRepository repository;

  public ServiceFactory(SensorsRepository repository)
  {
    this.repository = repository;
  }

  public SensorsService getSensorsService(){
    if(sensorsService ==null){
      sensorsService = new SensorsService(repository);
      return sensorsService;
    }
    return sensorsService;
  }}
