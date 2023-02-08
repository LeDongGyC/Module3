package service.iservice;

import bean.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();
    boolean insertServiceType(ServiceType serviceType);
    boolean deleteServiceType(int id);
}
