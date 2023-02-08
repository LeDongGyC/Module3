package controller;

import bean.ServiceType;
import service.impl.serivce.ServiceTypeService;
import service.iservice.IServiceTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceTypeServlet", urlPatterns = "/serviceType")
public class ServiceTypeServlet extends HttpServlet {
    private final IServiceTypeService serviceTypeService = new ServiceTypeService();

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
                delelte(request,response);
            default:
                showList(request, response);
        }
    }

    private void delelte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = serviceTypeService.deleteServiceType(id);
        String mess = "Xoa thanh cong";
        if (!check){
            mess = "Xoa that bai";
        }
        request.setAttribute("mess",mess);
        showList(request,response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        ServiceType serviceType = new ServiceType(name);
        boolean check = serviceTypeService.insertServiceType(serviceType);
        String mess = "them moi thanh cong";
        if (!check){
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
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        request.setAttribute("serviceTypeList",serviceTypeList);
        request.getRequestDispatcher("WEB-INF/view/service/listType.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/service/createServiceType.jsp").forward(request, response);
    }
}
