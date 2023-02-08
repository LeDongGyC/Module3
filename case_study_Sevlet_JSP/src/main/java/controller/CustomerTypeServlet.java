package controller;

import bean.CustomerType;
import service.icustomer.ICustomerTypeService;
import service.impl.customer.CustomerTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerTypeServlet", value = "/customerType")
public class CustomerTypeServlet extends HttpServlet {
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
            case "delete":
                delete(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = customerTypeService.deleteCustomerType(id);
        String mess = "Xoa thanh cong";
        if (!check){
            mess = "Xoa that bai";
        }
        request.setAttribute("mess",mess);
        showList(request,response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        CustomerType customerType = new CustomerType(name);
        boolean check = customerTypeService.insertCustomerType(customerType);
        String mess = "Them moi thanh cong";
        if (!check){
            mess = "Them moi that bai";
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

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/customer/createType.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        request.getRequestDispatcher("WEB-INF/view/customer/listType.jsp").forward(request, response);
    }
}
