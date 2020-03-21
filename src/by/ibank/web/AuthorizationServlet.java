package by.ibank.web;

import by.ibank.entity.User;
import by.ibank.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@WebServlet(urlPatterns = "/login", name = "Authorization")
public class AuthorizationServlet extends HttpServlet {

    private static Map<String, Locale> LOCALES = new HashMap<>();
    private static Map<String, String> LOCALE_OPTIONS = new LinkedHashMap<>();

    static {
        LOCALES.put("ru", new Locale("ru", "Ru"));
        LOCALES.put("en", new Locale("en", "En"));
        LOCALES.put("be", new Locale("be", "By"));
        LOCALES.put("de", new Locale("de", "De"));

        LOCALE_OPTIONS.put("en", "English");
        LOCALE_OPTIONS.put("ru", "Русский");
        LOCALE_OPTIONS.put("be", "Беларускi");
        LOCALE_OPTIONS.put("de", "Deutsch");
    }


    public static Locale getLocale(String str) {
        return LOCALES.getOrDefault(str, Locale.ENGLISH);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String language = req.getParameter("language");
        req.getSession().setAttribute("language", getLocale(language));
        req.getSession().setAttribute("locales", LOCALE_OPTIONS);
        req.getRequestDispatcher("/WEB-INF/jsp/log_in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("psw");
        User user = UserService.getInstance().getUserByLogin(login);
        if (user.getLogin() == null || !user.getPassword().equals(password)) {
            resp.getWriter().write("Incorrect login or password");
            //req.set;
            //req.getRequestDispatcher("/WEB-INF/jsp/log_in.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("currentUser", user);
            resp.sendRedirect("/main_paige");
//            req.setAttribute("user", user);
//            req.getRequestDispatcher("/WEB-INF/jsp/main_paige.jsp").forward(req, resp);
        }
    }
}
