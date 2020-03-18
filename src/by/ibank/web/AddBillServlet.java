package by.ibank.web;

import by.ibank.dao.impl.AccountDAOImpl;
import by.ibank.entity.Account;
import by.ibank.entity.User;
import by.ibank.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bills/add")
public class AddBillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/add_bill.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("currentUser");
        String accountNumber =  req.getParameter("accountNumber");
        int amount = Integer.parseInt(req.getParameter("amount"));
        AccountService.getInstance().addBill(user,new Account(accountNumber,amount));
        resp.sendRedirect("/bills");
    }
}
