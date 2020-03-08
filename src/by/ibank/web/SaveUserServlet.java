package by.ibank.web;

import by.ibank.dao.impl.UserDAOImpl;
import by.ibank.entity.User;
import by.ibank.entity.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/user/save", name = "SaveUserServlet")
public class SaveUserServlet extends HttpServlet {

    private UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String secondName = req.getParameter("second_name");
        String surname = req.getParameter("surname");
        String date = req.getParameter("birthday");
        Date birthday = null;
        try {
            birthday =  new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phone_number");
        String sex = req.getParameter("gender");
        String passportNumber = req.getParameter("passport_number");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        //UserRole role = (UserRole) req.getAttribute("role");
        User user = new User(name,secondName,surname,birthday,address,phoneNumber,sex,passportNumber,email,password,login);
        if (userDAO.save(user)) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/user/save");
        }
    }

}
