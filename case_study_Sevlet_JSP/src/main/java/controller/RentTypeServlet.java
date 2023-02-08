package controller;

import bean.RentType;
import service.impl.serivce.RentTypeService;
import service.iservice.IRentTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RentTypeServlet", urlPatterns = "/rentType")
public class RentTypeServlet extends HttpServlet {
    private final IRentTypeService rentTypeService = new RentTypeService();

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
        boolean check = rentTypeService.deleteRentType(id);
        String mess = "Xoa thanh cong";
        if (!check){
            mess = "Xoa that bai";
        }
        request.setAttribute("mess",mess);
        showList(request,response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double cost = Double.parseDouble(request.getParameter("cost"));
        RentType rentType = new RentType(name,cost);
        boolean check = rentTypeService.insertRentType(rentType);
        String mess = "them moi thanh cong";
        if(!check){
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
        List<RentType> rentTypeList = rentTypeService.findAll();
        request.setAttribute("rentTypeList",rentTypeList);
        request.getRequestDispatcher("WEB-INF/view/service/listRentType.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/service/createRentType.jsp").forward(request, response);

    }
}
