// src/main/java/com/example/login/LoginServlet.java
package com.example.login;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("admin".equals(user) && "password".equals(pass)) {
            request.setAttribute("username", user);
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        } else {
            response.getWriter().println("Invalid username or password");
        }
    }
}
