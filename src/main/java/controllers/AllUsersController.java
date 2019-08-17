package controllers;

import database.DBManager;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="AllUsersController", urlPatterns = "/allUsers")
public class AllUsersController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> users = DBManager.getAllActivUsers();
        req.setAttribute("allUsers", users);
        req.getRequestDispatcher("WEB-INF/jsp/allUser.jsp").forward(req, resp);
    }

}
