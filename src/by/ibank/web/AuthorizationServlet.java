package by.ibank.web;

import by.ibank.dao.impl.UserDAOImpl;
import by.ibank.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class AuthorizationServlet extends HttpServlet {
    UserDAOImpl userDAO = new UserDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("psw");
        User user = userDAO.findByLogin(login);

    }
}
