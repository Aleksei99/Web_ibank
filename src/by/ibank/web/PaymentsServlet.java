package by.ibank.web;

import by.ibank.entity.CreditCard;
import by.ibank.entity.User;
import by.ibank.service.CreditCardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = "/payments")
public class PaymentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("currentUser");
        LinkedList<CreditCard> creditCards = CreditCardService.getInstance().findAllUserCards(user);
        req.getSession().setAttribute("cards", creditCards);
        req.getRequestDispatcher("/WEB-INF/jsp/payments.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // String cardFrom = req.getParameter("cards");---??????
        try {
            String card = req.getParameter("cards");
            Integer cardNumber = Integer.parseInt(card);
            req.getSession().setAttribute("selectedCard", cardNumber);
        }catch (Exception e){
            e.printStackTrace();
        }

        int cardNumberFrom = (int) req.getSession().getAttribute("selectedCard");

        String cardTo = req.getParameter("cardNumber");
        String amount = req.getParameter("amount");
        //int cardNumberFrom = Integer.parseInt(cardFrom);
        int cardNumberTo = Integer.parseInt(cardTo);
        int amountTransfer = Integer.parseInt(amount);
        CreditCardService.getInstance().transferMoney(cardNumberFrom,amountTransfer,cardNumberTo);
        resp.sendRedirect("bills");
    }
}
