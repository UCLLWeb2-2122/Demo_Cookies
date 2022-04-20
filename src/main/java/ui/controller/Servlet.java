package ui.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
//        Cookie language = getCookieWithKey(request, "language");
//        request.setAttribute("requestCookie", language==null?"none":language.getValue());
        if (command == null)
            command = "";

        String destination;

        switch (command) {
            case "showEnglish":
                destination = switchToLanguage(request, response, "EN");
                break;
            case "showDutch":
                destination = switchToLanguage(request, response, "NL");
                break;
            case "somethingMore":
                destination = somethingMore(request);
                break;
            default:
                destination = goHome(request);
        }

        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String somethingMore(HttpServletRequest request) {
        Cookie cookie = getCookieWithKey(request, "language");
        if (cookie != null && cookie.getValue().equals("EN")) {
            return "somethingMore.jsp";
        } else
            return "meerTekst.jsp";
    }

    private String goHome(HttpServletRequest request) {
        Cookie cookie = getCookieWithKey(request, "language");
        if (cookie == null || cookie.getValue().equals("NL")) {
            return "welkom.jsp";
        } else {
            return "welcome.jsp";
        }
    }

    private String switchToLanguage(HttpServletRequest request, HttpServletResponse response, String language) {
        String destination;

        Cookie c = new Cookie("language", language);
        response.addCookie(c);

        if (language == null || language.equals("NL")) {
            request.setAttribute("requestCookie", "NL");
            destination = "welkom.jsp";
        } else {
            request.setAttribute("requestCookie", "EN");
            destination = "welcome.jsp";
        }
        return destination;
    }

    private Cookie getCookieWithKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return null;
        for (Cookie cookie : cookies
        ) {
            if (cookie.getName().equals(key))
                return cookie;
        }
        return null;
    }
}
