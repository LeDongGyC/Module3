package service.impl.serivce;

import bean.ServiceType;
import repository.iservice.IServiceTypeRepository;
import repository.impl.service.ServiceTypeRepository;
import service.iservice.IServiceTypeService;

import java.util.List;

public class ServiceTypeService implements IServiceTypeService {
    private final IServiceTypeRepository serviceTypeRepository = new ServiceTypeRepository();

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public boolean insertServiceType(ServiceType serviceType) {
        return serviceTypeRepository.insertServiceType(serviceType);
    }

    @Override
    public boolean deleteServiceType(int id) {
        return serviceTypeRepository.deleteServiceType(id);
    }
}
