package service.iservice;

import bean.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
    boolean insertRentType(RentType rentType);
    boolean deleteRentType(int id);
}
