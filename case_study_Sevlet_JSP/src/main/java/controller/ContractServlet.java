package controller;

import bean.Contract;
import bean.Customer;
import bean.Employee;
import bean.Service;
import service.icontract.IContractService;
import service.icustomer.ICustomerService;
import service.iemployee.IEmployeeService;
import service.impl.contract.ContractService;
import service.impl.customer.CustomerService;
import service.impl.employee.EmployeeService;
import service.impl.serivce.ServiceService;
import service.iservice.IServiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", value = "/contract")
public class ContractServlet extends HttpServlet {
    private final IContractService contractService = new ContractService();
    private final IEmployeeService employeeService = new EmployeeService();
    private final ICustomerService customerService = new CustomerService();
    private final IServiceService serviceService = new ServiceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double total = Double.parseDouble(request.getParameter("total"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = new Employee(employeeId);
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        Customer customer = new Customer(customerId);
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        Service service = new Service(serviceId);
        Contract contract = new Contract(start, end, deposit, total, employee, customer, service);
        boolean check = contractService.insertContract(contract);
        String mess = "them moi thanh cong";
        if (!check) {
            mess = "them moi that bai";
        }
        request.setAttribute("mess",mess);
        showCreateForm(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = contractService.findAll();
        request.setAttribute("contractList", contractList);
        request.getRequestDispatcher("WEB-INF/view/contract/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.findAll();
        List<Customer> customerList = customerService.findAll();
        List<Service> serviceList = serviceService.findAll();
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("serviceList", serviceList);
        request.getRequestDispatcher("WEB-INF/view/contract/create.jsp").forward(request, response);
    }
}
