package repository.iemployee;

import bean.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> findAll();

    boolean insertPosition(Position position);
}
