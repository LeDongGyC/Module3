package service.impl.serivce;

import bean.RentType;
import repository.iservice.IRentTypeRepository;
import repository.impl.service.RentTypeRepository;
import service.iservice.IRentTypeService;

import java.util.List;

public class RentTypeService implements IRentTypeService {
    private final IRentTypeRepository rentTypeRepository = new RentTypeRepository();
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public boolean insertRentType(RentType rentType) {
        return rentTypeRepository.insertRentType(rentType);
    }

    @Override
    public boolean deleteRentType(int id) {
        return rentTypeRepository.deleteRentType(id);
    }
}
