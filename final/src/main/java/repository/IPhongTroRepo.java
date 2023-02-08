package repository;

import bean.PhongTro;

import java.util.List;

public interface IPhongTroRepo {
    List<PhongTro> findAll();
    boolean insertPhongTro(PhongTro phongTro);

    boolean deleteEmployee(int id);

    PhongTro findById(int id);

    List<PhongTro> search(String idSearch, String nameSearch, String phoneSearch);
}

