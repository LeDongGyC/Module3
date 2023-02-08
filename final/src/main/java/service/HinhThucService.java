package service;

import bean.HinhThuc;
import repository.HinhThucRepo;
import repository.IHinhThucRepo;

import java.util.List;

public class HinhThucService implements IHinhThucService{
    private IHinhThucRepo hinhThucRepo = new HinhThucRepo();
    @Override
    public List<HinhThuc> findAll() {
        return hinhThucRepo.findAll();
    }
}
