package repository.iservice;

import bean.RentType;

import java.util.List;

public interface IRentTypeRepository {
    List<RentType> findAll();
    boolean insertRentType(RentType rentType);
    boolean deleteRentType(int id);
}
