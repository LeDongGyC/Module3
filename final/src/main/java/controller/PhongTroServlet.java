package controller;

import bean.HinhThuc;
import bean.PhongTro;
import service.HinhThucService;
import service.IHinhThucService;
import service.IPhongTroService;
import service.PhongTroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/phongtro")
public class PhongTroServlet extends HttpServlet {
    private IPhongTroService phongTroService = new PhongTroService();
    private IHinhThucService hinhThucService = new HinhThucService();

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
                delete(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("deleteId"));
        boolean check = phongTroService.deleteEmployee(id);
        String mess = "Xoa thanh cong";
        if (!check) {
            mess = "Xoa that bai";
        }
        request.setAttribute("mess", mess);
        response.sendRedirect("phongtro");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String ngayThue = request.getParameter("ngayThue");
        int idType = Integer.parseInt(request.getParameter("idType"));
        HinhThuc hinhThuc = new HinhThuc(idType);
        String ghiChu = request.getParameter("ghiChu");
        PhongTro phongTro = new PhongTro(name, phone, ngayThue, hinhThuc, ghiChu);
        boolean check = phongTroService.insertPhongTro(phongTro);
        String mess = "Them moi thanh cong";
        if (!check) {
            mess = "Them moi that bai";
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
            case "search":
                search(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idSearch = request.getParameter("idSearch");
        String[] temp = idSearch.split("");
        String index;
        if (idSearch == ""){
            index = "";
        } else {
             index = temp[5];
        }
        String nameSearch = request.getParameter("nameSearch");
        String phoneSearch = request.getParameter("phoneSearch");
        request.setAttribute("idSearch", idSearch);
        request.setAttribute("nameSearch", nameSearch);
        request.setAttribute("phoneSearch", phoneSearch);
        List<PhongTro> phongTroList = phongTroService.search(index, nameSearch, phoneSearch);
        request.setAttribute("phongTroList", phongTroList);
        request.getRequestDispatcher("WEB-INF/view/phongtro/list.jsp").forward(request, response);
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PhongTro> phongTroList = phongTroService.findAll();
        request.setAttribute("phongTroList", phongTroList);
        request.getRequestDispatcher("WEB-INF/view/phongtro/list.jsp").forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HinhThuc> hinhThucList = hinhThucService.findAll();
        request.setAttribute("hinhThucList", hinhThucList);
        request.getRequestDispatcher("WEB-INF/view/phongtro/create.jsp").forward(request, response);
    }
}
