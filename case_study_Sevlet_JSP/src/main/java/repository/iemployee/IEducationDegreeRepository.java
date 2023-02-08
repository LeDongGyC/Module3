package repository.iemployee;

import bean.EducationDegree;

import java.util.List;

public interface IEducationDegreeRepository {
    List<EducationDegree> findAll();
    boolean insertEducationDegree(EducationDegree educationDegree);
}
