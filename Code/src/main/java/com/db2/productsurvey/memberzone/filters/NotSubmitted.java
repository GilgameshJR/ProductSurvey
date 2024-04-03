package com.db2.productsurvey.memberzone.filters;

import com.db2.productsurvey.Error;
import com.db2.productsurvey.ErrorUtils;
import com.db2.productsurvey.beans.ResponseServiceBean;
import com.db2.productsurvey.entities.Response;
import com.db2.productsurvey.entities.SimpleUser;

import javax.ejb.EJB;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class NotSubmitted extends HttpFilter {
    @EJB(name = "com.db2.productsurvey.beans/ResponseServiceBean")
    private ResponseServiceBean responseService;

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Response response = responseService.getResponseByUserForQuestionnaire(((SimpleUser) req.getSession().getAttribute("user")).getUsername(), LocalDate.now());
        if (response == null) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(req.getContextPath() + ErrorUtils.getErrorPagePathFromContext(Error.MEMBER_QUESTIONNAIREALREADYSUMBITTED));
        }
    }

    @Override
    public void destroy() {

    }
}