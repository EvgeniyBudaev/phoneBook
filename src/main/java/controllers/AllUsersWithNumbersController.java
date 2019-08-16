package controllers;

import database.DBManager;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;

@WebServlet(name="AllUsersWithNumbersController", urlPatterns = "/allUsersWithNumbers")
public class AllUsersWithNumbersController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LinkedHashMap<User, String>  usersWithNumbers = DBManager.getAllActivUsersWithNumbers();
        req.setAttribute("usersWithNumbers", usersWithNumbers);
        req.getRequestDispatcher("WEB-INF/jsp/usersWithNumbers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("idUser"); //s - имя hidden
        String[] idsMassiv = ids.split(",");
        for(String id: idsMassiv){
            DBManager.deleteUser(id);
        }
        resp.sendRedirect("/allUsers");
    }

}
