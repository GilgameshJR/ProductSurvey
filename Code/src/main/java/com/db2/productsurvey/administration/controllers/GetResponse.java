package com.db2.productsurvey.administration.controllers;

import com.db2.productsurvey.Error;
import com.db2.productsurvey.ErrorUtils;
import com.db2.productsurvey.beans.ProductServiceBean;
import com.db2.productsurvey.beans.ResponseServiceBean;
import com.db2.productsurvey.entities.Response;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class GetResponse extends HttpServlet {
    @EJB(name = "com.db2.productsurvey.beans/ResponseServiceBean")
    private ResponseServiceBean responseService;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String idStr=req.getParameter("id");
            if (idStr==null || idStr.length()==0) {
                res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.MISSINGPARAMETER));
                return;
            }
            int id = parseInt(idStr);
            Response response = responseService.getResponse(id);
            req.setAttribute("response", response);
            req.getRequestDispatcher("/WEB-INF/administration/response.jsp").forward(req, res);
        } catch (NumberFormatException e) {
            res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.ILLEGALPARAMETER));
            return;
        }
    }
}