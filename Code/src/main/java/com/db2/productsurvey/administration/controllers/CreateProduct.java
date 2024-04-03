package com.db2.productsurvey.administration.controllers;

import com.db2.productsurvey.Error;
import com.db2.productsurvey.ErrorUtils;
import com.db2.productsurvey.ImageUtils;
import com.db2.productsurvey.beans.ProductServiceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet//(name = "Servlet", value = "/memberzone")
@MultipartConfig
public class CreateProduct extends HttpServlet {
    @EJB(name = "com.db2.productsurvey.beans/ProductServiceBean")
    ProductServiceBean productService;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name=req.getParameter("name");
        Part imgFile = req.getPart("picture");

        if (name==null || name.trim().length()==0 || imgFile==null) {
            res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.MISSINGPARAMETER));
            return;
        }

        InputStream imgContent = imgFile.getInputStream();
        byte[] imgByteArray = ImageUtils.readImage(imgContent);

        if (imgByteArray.length == 0) {
            res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.MISSINGPARAMETER));
            return;
        }
        productService.createProduct(name, imgByteArray);
        res.sendRedirect(req.getContextPath() + "/administration/manageproducts");
    }
}