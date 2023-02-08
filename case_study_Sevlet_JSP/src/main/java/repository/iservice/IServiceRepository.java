package repository.iservice;

import bean.Service;

import java.util.List;

public interface IServiceRepository {
    List<Service> findAll();

    boolean insertService(Service service);
}
