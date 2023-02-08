package repository.iemployee;

import bean.Division;

import java.util.List;

public interface IDivisionRepository {
    List<Division> findAll();
    boolean insertDivision(Division division);
}
