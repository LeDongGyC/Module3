package service.impl.employee;

import bean.EducationDegree;
import repository.iemployee.IEducationDegreeRepository;
import repository.impl.employee.EducationDegreeRepository;
import service.iemployee.IEducationDegreeService;

import java.util.List;

public class EducationDegreeService implements IEducationDegreeService {
    private final IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public boolean insertEducationDegree(EducationDegree educationDegree) {
        return educationDegreeRepository.insertEducationDegree(educationDegree);
    }
}
