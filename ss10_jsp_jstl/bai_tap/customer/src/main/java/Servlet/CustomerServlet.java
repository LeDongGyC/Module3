package Servlet;

import Model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    public static List<Customer> customerList = new LinkedList<Customer>();
    static {
        customerList.add(new Customer("Phạm Lê Đông 1","17/05/2003","Quảng Nam"));
        customerList.add(new Customer("Phạm Lê Đông 2","17/05/2003","Quảng Ngãi"));
        customerList.add(new Customer("Phạm Lê Đông 3","17/05/2003","Quảng Ninh"));
        customerList.add(new Customer("Phạm Lê Đông 4","17/05/2003","Quảng Nam"));
        customerList.add(new Customer("Phạm Lê Đông 5","17/05/2003","Quảng Nam"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("view/customer.jsp").forward(request,response);
    }
}
