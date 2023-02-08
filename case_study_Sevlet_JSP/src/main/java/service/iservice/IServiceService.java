package service.iservice;

import bean.Service;

import java.util.List;

public interface IServiceService {
    List<Service> findAll();

    boolean insertService(Service service);
}
