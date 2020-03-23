package by.ibank.web;

import by.ibank.dao.impl.AccountDAOImpl;
import by.ibank.entity.User;
import by.ibank.service.AccountService;
import by.ibank.service.CreditCardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bills")
public class BillsPaigeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("currentUser");
        req.setAttribute("accounts", AccountService.getInstance().allUserAccounts(user));
        req.setAttribute("creditCards", CreditCardService.getInstance().findAllUserCards(user));
        req.getRequestDispatcher("/WEB-INF/jsp/bills.jsp").forward(req,resp);
    }
}
