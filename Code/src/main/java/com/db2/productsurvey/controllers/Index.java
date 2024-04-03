package com.db2.productsurvey.controllers;

import com.db2.productsurvey.entities.Admin;
import com.db2.productsurvey.entities.SimpleUser;
import com.db2.productsurvey.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class Index extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession sess = req.getSession();
        String ContextPath = req.getContextPath();

        if (sess == null || sess.isNew() || sess.getAttribute("user") == null) {
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, res);
        }
        else {
            User user= (User) sess.getAttribute("user");
            if (user instanceof SimpleUser)
                res.sendRedirect(ContextPath+"/memberzone");
            else if (user instanceof Admin)
                res.sendRedirect(ContextPath+"/administration");
            else
                req.getRequestDispatcher("/WEB-INF/index.jsp");
        }
    }
}