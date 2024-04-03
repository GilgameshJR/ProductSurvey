package com.db2.productsurvey.administration.filters;

import com.db2.productsurvey.entities.Admin;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoggedCheck extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession sess = req.getSession();
        String ContextPath = req.getContextPath();

        if (sess == null || sess.isNew() || sess.getAttribute("user") == null) {
            res.sendRedirect(ContextPath);
        } else {
            Object user = sess.getAttribute("user");
            if (!(user instanceof Admin))
                res.sendRedirect(ContextPath);
            else {
                req.setAttribute("username", ((Admin) user).getUsername());
                chain.doFilter(req, res);
            }
        }
    }

    @Override
    public void destroy() {

    }
}