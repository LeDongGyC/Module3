package controller;

import bean.Customer;
import bean.RentType;
import bean.Service;
import bean.ServiceType;
import service.impl.serivce.RentTypeService;
import service.impl.serivce.ServiceService;
import service.impl.serivce.ServiceTypeService;
import service.iservice.IRentTypeService;
import service.iservice.IServiceService;
import service.iservice.IServiceTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private final IServiceTypeService serviceTypeService = new ServiceTypeService();
    private final IRentTypeService rentTypeService = new RentTypeService();
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
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        RentType rentType = new RentType(rentTypeId);
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        ServiceType serviceType = new ServiceType(serviceTypeId);
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service = new Service(name,area,cost,maxPeople,rentType,serviceType,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors);
        boolean check = serviceService.insertService(service);
        String message = "Them moi thanh cong";
        if (!check){
            message = "Them moi that bai";
        }
        request.setAttribute("message",message);
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
                showListService(request, response);

        }
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = serviceService.findAll();
        request.setAttribute("serviceList", serviceList);
        request.getRequestDispatcher("WEB-INF/view/service/list.jsp").forward(request, response);

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentType> rentTypeList = rentTypeService.findAll();
        request.setAttribute("rentTypeList", rentTypeList);
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.getRequestDispatcher("WEB-INF/view/service/create.jsp").forward(request, response);
    }
}
