package com.db2.productsurvey.memberzone.controllers;

import com.db2.productsurvey.beans.QuestionnaireServiceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class Reviews extends HttpServlet {

    @EJB(name = "com.db2.productsurvey.beans/QuestionnaireServiceBean")
    private QuestionnaireServiceBean questionnaireService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("product", questionnaireService.getTodayQuestionnaire().getProduct());
        req.getRequestDispatcher("/WEB-INF/memberzone/reviews.jsp").forward(req, res);
    }
}