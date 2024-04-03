package com.db2.productsurvey.controllers;

import com.db2.productsurvey.Error;
import com.db2.productsurvey.ErrorUtils;
import com.db2.productsurvey.beans.UserServiceBean;
import com.db2.productsurvey.entities.Admin;
import com.db2.productsurvey.entities.SimpleUser;
import com.db2.productsurvey.entities.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class Login extends HttpServlet {
    @EJB(name = "com.db2.productsurvey.beans/UserServiceBean")
    UserServiceBean userService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String ContextPath = req.getContextPath();
        String username=req.getParameter("username").trim();
        String password=req.getParameter("password");

        if (username==null || password==null) {
            res.sendRedirect(ContextPath + ErrorUtils.getErrorPagePathFromContext(Error.MISSINGPARAMETER));
            return;
        }

        User user = userService.checkCredentials(username, password);
        if (user instanceof SimpleUser) {
            req.getSession().setAttribute("user", user);
            res.sendRedirect(ContextPath + "/memberzone");
        } else if (user instanceof Admin) {
            req.getSession().setAttribute("user", user);
            res.sendRedirect(ContextPath + "/administration");
        } else {
            res.sendRedirect(ContextPath+ErrorUtils.getErrorPagePathFromContext(Error.WRONGCREDENTIALS));
        }
    }
}