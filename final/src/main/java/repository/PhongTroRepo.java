package repository;

import bean.HinhThuc;
import bean.PhongTro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongTroRepo implements IPhongTroRepo {
    private String SELECT_ALL = "select pt.*,ht.name_type from phong_tro pt join hinh_thuc ht on pt.id_type = ht.id_type";
    private String INSERT_INTO = "insert into phong_tro(name,phone,ngay_thue,id_type,ghi_chu) values(?,?,?,?,?)";
    private String SELECT_BY_ID = "select pt.*,ht.name_type from phong_tro pt join hinh_thuc ht on pt.id_type = ht.id_type where pt.id = ?";
    private String DELETE = "delete from phong_tro where id = ?";
    private String SEARCH = "select pt.*,ht.name_type from phong_tro pt join hinh_thuc ht on pt.id_type = ht.id_type where pt.id like ? and pt.name like ? and pt.phone like ?";

    @Override
    public List<PhongTro> findAll() {
        List<PhongTro> phongTroList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String ngayThue = resultSet.getString("ngay_thue");
                int idType = resultSet.getInt("id_type");
                String nameType = resultSet.getString("name_type");
                HinhThuc hinhThuc = new HinhThuc(idType, nameType);
                String ghiChu =resultSet.getString("ghi_chu");
                PhongTro phongTro = new PhongTro(id, name, phone, ngayThue, hinhThuc,ghiChu);
                phongTroList.add(phongTro);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTroList;
    }

    @Override
    public boolean insertPhongTro(PhongTro phongTro) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, phongTro.getName());
            preparedStatement.setString(2, phongTro.getPhone());
            preparedStatement.setString(3, phongTro.getNgayThue());
            preparedStatement.setInt(4, phongTro.getHinhThuc().getIdType());
            preparedStatement.setString(5,phongTro.getGhiChu());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public PhongTro findById(int id) {
        PhongTro phongTro = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String ngayThue = resultSet.getString("ngay_thue");
                int idType = resultSet.getInt("id_type");
                String nameType = resultSet.getString("name_type");
                HinhThuc hinhThuc = new HinhThuc(idType, nameType);
                String ghiChu =resultSet.getString("ghi_chu");
                phongTro = new PhongTro(id, name, phone, ngayThue, hinhThuc,ghiChu);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTro;
    }

    @Override
    public List<PhongTro> search(String idSearch, String nameSearch, String phoneSearch) {
        List<PhongTro> phongTroList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + idSearch + "%");
            preparedStatement.setString(2, "%" + nameSearch + "%");
            preparedStatement.setString(3, "%" + phoneSearch + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String phone = resultSet.getString("phone");
                String ngayThue = resultSet.getString("ngay_thue");
                int idType = resultSet.getInt("id_type");
                String nameType = resultSet.getString("name_type");
                HinhThuc hinhThuc = new HinhThuc(idType, nameType);
                String ghiChu =resultSet.getString("ghi_chu");
                PhongTro phongTro = new PhongTro(id, name, phone, ngayThue, hinhThuc,ghiChu);
                phongTroList.add(phongTro);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTroList;
    }
}
