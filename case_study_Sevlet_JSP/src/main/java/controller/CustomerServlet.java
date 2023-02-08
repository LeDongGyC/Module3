package controller;

import bean.Customer;
import bean.CustomerType;
import service.impl.customer.CustomerService;
import service.impl.customer.CustomerTypeService;
import service.icustomer.ICustomerService;
import service.icustomer.ICustomerTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private final ICustomerService customerService = new CustomerService();
    private final ICustomerTypeService customerTypeService = new CustomerTypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = customerService.deleteCustomer(id);
        String mess = "Xoá thành công";
        if (!check) {
            mess = "Xoá thất bại";
        }
        request.setAttribute("mess", mess);
        showListCustomer(request,response);
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        CustomerType customerType = new CustomerType(customerTypeId);
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(customer_id, customerType, name, birthday, gender, idCard, phone, email, address);
        customerService.updateCustomer(customer);
        response.sendRedirect("/customer");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        CustomerType customerType = new CustomerType(customerTypeId);
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(customerType, name, birthday, gender, idCard, phone, email, address);
        boolean check = customerService.insertCustomer(customer);
        String message = "Thêm mới thành công";
        if (!check) {
            message = "Thêm mới thất bại";
            request.setAttribute("customer", customer);
        }
        request.setAttribute("message", message);
        showCreateForm(request, response);
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
            case "edit":
                showEditForm(request, response);
                break;
            case "findCustomer":
                searchCustomer(request, response);
                break;
//            case "delete":
//                deleteCustomer(request, response);
//                break;
            default:
                showListCustomer(request, response);
        }

    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("WEB-INF/view/customer/list.jsp").forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        customerService.deleteCustomer(customer_id);
        response.sendRedirect("/customer");
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        Customer customer = customerService.selectById(customer_id);
//        String checked = null;
        if (customer.getCustomerGender()==0){ // 1 nam 0 nu
            request.setAttribute("checked","checked = checked");
        }

        request.setAttribute("customer", customer);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        request.getRequestDispatcher("WEB-INF/view/customer/edit.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        request.getRequestDispatcher("WEB-INF/view/customer/create.jsp").forward(request, response);
    }
}
