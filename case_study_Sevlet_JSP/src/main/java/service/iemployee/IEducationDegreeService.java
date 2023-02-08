package service.iemployee;

import bean.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();
    boolean insertEducationDegree(EducationDegree educationDegree);
}
