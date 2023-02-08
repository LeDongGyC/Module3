package service;

import bean.PhongTro;
import repository.IPhongTroRepo;
import repository.PhongTroRepo;

import java.util.List;

public class PhongTroService implements IPhongTroService{
    private IPhongTroRepo phongTroRepo = new PhongTroRepo();
    @Override
    public List<PhongTro> findAll() {
        return phongTroRepo.findAll();
    }

    @Override
    public boolean insertPhongTro(PhongTro phongTro) {
        return phongTroRepo.insertPhongTro(phongTro);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return phongTroRepo.deleteEmployee(id);
    }

    @Override
    public PhongTro findById(int id) {
        return phongTroRepo.findById(id);
    }

    @Override
    public List<PhongTro> search(String idSearch, String nameSearch, String phoneSearch) {
        return phongTroRepo.search(idSearch, nameSearch, phoneSearch);
    }
}
