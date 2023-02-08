package service.iemployee;

import bean.Position;

import java.util.List;

public interface IPositionSerivce {
    List<Position> findAll();

    boolean insertPosition(Position position);
}
