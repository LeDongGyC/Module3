package repository.iservice;

import bean.ServiceType;

import java.util.List;

public interface IServiceTypeRepository {
    List<ServiceType> findAll();
    boolean insertServiceType(ServiceType serviceType);
    boolean deleteServiceType(int id);
}
