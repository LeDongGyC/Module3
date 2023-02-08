package repository;

import bean.HinhThuc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HinhThucRepo implements IHinhThucRepo {
    private String SELECT_ALL = "select * from hinh_thuc";

    @Override
    public List<HinhThuc> findAll() {
        List<HinhThuc> hinhThucList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idType = resultSet.getInt("id_type");
                String nameType = resultSet.getString("name_type");
                HinhThuc hinhThuc = new HinhThuc(idType, nameType);
                hinhThucList.add(hinhThuc);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hinhThucList;
    }
}
