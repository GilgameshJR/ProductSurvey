package com.db2.productsurvey.administration.controllers;

import com.db2.productsurvey.beans.ProductServiceBean;
import com.db2.productsurvey.beans.QuestionnaireServiceBean;
import com.db2.productsurvey.entities.Product;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class NewQuestionnaire extends HttpServlet {
    @EJB(name = "com.db2.productsurvey.beans/ProductServiceBean")
    private ProductServiceBean productService;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Product> products=productService.getProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/administration/newquestionnaire.jsp").forward(req, res);
    }
}