package controller;

import bean.*;
import service.iemployee.*;
import service.impl.employee.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private final IEmployeeService employeeService = new EmployeeService();
    private final IPositionSerivce positionService = new PositionService();
    private final IDivisionService divisionService = new DivisionService();
    private final IEducationDegreeService educationDegreeService = new EducationDegreeService();
    private final IUserService userService = new UserService();

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
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = employeeService.deleteEmployee(id);
        response.sendRedirect("/employee");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("employee_id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        Position position = new Position(positionId);
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        EducationDegree educationDegree = new EducationDegree(educationDegreeId);
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Division division = new Division(divisionId);
        String username = request.getParameter("username");
        User user = new User(username);
        Employee employee = new Employee(id,name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, user);
        employeeService.updateEmployee(employee);
        response.sendRedirect("/employee");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        Position position = new Position(positionId);
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        EducationDegree educationDegree = new EducationDegree(educationDegreeId);
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Division division = new Division(divisionId);
        String username = request.getParameter("username");
        User user = new User(username);
        Employee employee = new Employee(name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, user);
        boolean check = employeeService.insertEmployee(employee);
        String mess = "Them moi thanh cong";
        if (!check) {
            mess = "them moi that bai";
        }
        request.setAttribute("mess", mess);
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
                searchEmployee(request, response);
                break;
            case "search":
                search3(request,response);
                break;
//            case "delete":
//                deleteEmployee(request, response);
//                break;
            default:
                showListEmployee(request, response);
        }
    }

    private void search3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameSearch = request.getParameter("nameSearch");
        String emailSearch = request.getParameter("emailSearch");
        String positionIdSearch = request.getParameter("positionIdSearch");
        request.setAttribute("nameSearch",nameSearch);
        request.setAttribute("emailSearch",emailSearch);
        request.setAttribute("positionIdSearch",positionIdSearch);
        List<Employee> employeeList = employeeService.search(nameSearch,emailSearch,positionIdSearch);
        request.setAttribute("employeeList", employeeList);
        List<Position> positionList = positionService.findAll();
        request.setAttribute("positionList",positionList);
        request.getRequestDispatcher("WEB-INF/view/employee/list.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("employee_id"));
        employeeService.deleteEmployee(id);
        response.sendRedirect("/employee");
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("employee_id"));
        Employee employee = employeeService.selectById(id);
        request.setAttribute("employee", employee);
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<User> userList = userService.findAll();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("WEB-INF/view/employee/edit.jsp").forward(request, response);
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList", employeeList);
        List<Position> positionList = positionService.findAll();
        request.setAttribute("positionList",positionList);
        request.getRequestDispatcher("WEB-INF/view/employee/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        List<Division> divisionList = divisionService.findAll();
        List<User> userList = userService.findAll();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("WEB-INF/view/employee/create.jsp").forward(request, response);
    }
}
