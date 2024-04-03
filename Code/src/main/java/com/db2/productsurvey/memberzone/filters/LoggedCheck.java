package com.db2.productsurvey.memberzone.filters;

import com.db2.productsurvey.Error;
import com.db2.productsurvey.ErrorUtils;
import com.db2.productsurvey.entities.SimpleUser;

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
            Object user= sess.getAttribute("user");
            if (user instanceof SimpleUser) {
                if (((SimpleUser) user).isBlocked())
                    res.sendRedirect(req.getContextPath() + ErrorUtils.getErrorPagePathFromContext(Error.MEMBER_BLOCKED));
                else {
                    req.setAttribute("username", ((SimpleUser) user).getUsername());
                    chain.doFilter(req, res);
                }
            } else {
                res.sendRedirect(ContextPath);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
