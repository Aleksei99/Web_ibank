package by.ibank.web;

import by.ibank.entity.Account;
import by.ibank.entity.CreditCard;
import by.ibank.service.AccountService;
import by.ibank.service.CreditCardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = "/bills/add-card")
public class AddCardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/add_card.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountNumber = req.getParameter("accountNumber");
        int cardNumber  = Integer.parseInt(req.getParameter("cardNumber"));
        int month = Integer.parseInt(req.getParameter("month"));
        int year =Integer.parseInt( req.getParameter("year"));
        LocalDate date = LocalDate.of(year,month,1);
        CreditCardService.getInstance().addCard(AccountService.getInstance().find(accountNumber),new CreditCard(cardNumber,date));
    }
}
