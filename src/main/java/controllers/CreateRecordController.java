package controllers;

import database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name="CreateRecordController", urlPatterns = "/createRecord")
public class CreateRecordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/createRecord.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String surnameUser = req.getParameter("surname");
        String nameUser = req.getParameter("name");
        String patronymicUser = req.getParameter("patronymic");
        String phoneNumberUser = req.getParameter("phoneNumber");

        if(surnameUser.equals("") || nameUser.equals("") || patronymicUser.equals("")){
            req.setAttribute("error", "1");
            req.getRequestDispatcher("WEB-INF/jsp/createRecord.jsp").forward(req, resp);
        }else {
            DBManager.createRecord(surnameUser, nameUser, patronymicUser, phoneNumberUser);
            resp.sendRedirect("/"); //передаем управление на другой контроллер
        }

    }
}
