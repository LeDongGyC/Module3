package service.iemployee;

import bean.Division;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();
    boolean insertDivision(Division division);
}
