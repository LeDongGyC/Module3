package service.impl.employee;

import bean.Position;
import repository.iemployee.IPositionRepository;
import repository.impl.employee.PositionRepository;
import service.iemployee.IPositionSerivce;

import java.util.List;

public class PositionService implements IPositionSerivce {
    private final IPositionRepository positionRepository = new PositionRepository();

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public boolean insertPosition(Position position) {
        return positionRepository.insertPosition(position);
    }
}
