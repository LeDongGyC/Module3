package service.impl.serivce;

import bean.Service;
import repository.iservice.IServiceRepository;
import repository.impl.service.ServiceRepository;
import service.iservice.IServiceService;

import java.util.List;

public class ServiceService implements IServiceService {
    private final IServiceRepository serviceRepository = new ServiceRepository();

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public boolean insertService(Service service) {
        return serviceRepository.insertService(service);
    }
}
