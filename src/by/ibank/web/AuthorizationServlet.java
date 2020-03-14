package by.ibank.web;

import by.ibank.dao.impl.UserDAOImpl;
import by.ibank.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login",name = "Authorization")
public class AuthorizationServlet extends HttpServlet {
    UserDAOImpl userDAO = UserDAOImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/log_in.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("psw");
        User user = userDAO.findByLogin(login);
        if(user.getLogin()==null || !user.getPassword().equals(password)){
            resp.getWriter().write("Incorrect login or password");
            //req.set;
            //req.getRequestDispatcher("/WEB-INF/jsp/log_in.jsp").forward(req, resp);
        }else {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/jsp/main_paige.jsp").forward(req, resp);
        }
    }
}
