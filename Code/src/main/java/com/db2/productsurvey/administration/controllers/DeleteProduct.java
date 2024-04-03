package com.db2.productsurvey.administration.controllers;

import com.db2.productsurvey.Error;
import com.db2.productsurvey.ErrorUtils;
import com.db2.productsurvey.beans.ProductServiceBean;
import com.db2.productsurvey.beans.QuestionnaireServiceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class DeleteProduct extends HttpServlet {
    @EJB(name = "com.db2.productsurvey.beans/ProductServiceBean")
    ProductServiceBean productService;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String idStr=req.getParameter("product");
            if (idStr==null || idStr.trim().length()==0) {
                res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.MISSINGPARAMETER));
                return;
            }
            int id=parseInt(idStr);
            productService.deleteProduct(id);
            res.sendRedirect(req.getContextPath()+"/administration/manageproducts");
        } catch (NumberFormatException e) {
            res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.ILLEGALPARAMETER));
            return;
        }
    }
}