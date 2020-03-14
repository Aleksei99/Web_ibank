package by.ibank.web;

import by.ibank.dao.impl.UserDAOImpl;
import by.ibank.dto.ViewFullUserInfoDto;
import by.ibank.entity.User;
import by.ibank.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/search",name = "SearchServlet")
public class SearchUserByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        ViewFullUserInfoDto user = UserService.getInstance().getFullUserInfo(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(req, resp);
    }
}
