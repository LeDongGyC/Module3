package service.impl.employee;

import bean.Division;
import repository.iemployee.IDivisionRepository;
import repository.impl.employee.DivisionRepository;
import service.iemployee.IDivisionService;

import java.util.List;

public class DivisionService implements IDivisionService {
    private final IDivisionRepository divisionRepository = new DivisionRepository();
    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public boolean insertDivision(Division division) {
        return divisionRepository.insertDivision(division);
    }
}
