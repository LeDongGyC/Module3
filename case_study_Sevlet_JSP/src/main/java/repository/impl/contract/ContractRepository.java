package repository.impl.contract;

import bean.Contract;
import bean.Customer;
import bean.Employee;
import bean.Service;
import repository.icontract.IContractRepository;
import utils.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    private final String SELECT_ALL_SERVICE = "select ct.*,e.employee_name,c.customer_name,s.service_name from contract ct join employee e on ct.employee_id = e.employee_id join customer c on ct.customer_id = c.customer_id join service s on ct.service_id = s.service_id;";
    private final String INSERT_INTO = "insert into contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id) values(?, ?, ?, ?, ?, ? ,?)";

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contract_id = resultSet.getInt("contract_id");
                String contract_start_date = resultSet.getString("contract_start_date");
                String contract_end_date = resultSet.getString("contract_end_date");
                double contract_deposit = resultSet.getDouble("contract_deposit");
                double contract_total_money = resultSet.getDouble("contract_total_money");
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                Employee employee = new Employee(employee_id, employee_name);
                int customer_id = resultSet.getInt("customer_id");
                String customer_name = resultSet.getString("customer_name");
                Customer customer = new Customer(customer_id, customer_name);
                int service_id = resultSet.getInt("service_id");
                String service_name = resultSet.getString("service_name");
                Service service = new Service(service_id, service_name);
                Contract contract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee, customer, service);
                contractList.add(contract);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public boolean insertContract(Contract contract) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, contract.getContractStartDate());
            preparedStatement.setString(2, contract.getContractEndDate());
            preparedStatement.setDouble(3, contract.getContractDeposit());
            preparedStatement.setDouble(4, contract.getContractTotalMoney());
            preparedStatement.setInt(5, contract.getEmployee().getEmployeeId());
            preparedStatement.setInt(6, contract.getCustomer().getCustomerId());
            preparedStatement.setInt(7, contract.getService().getServiceId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
