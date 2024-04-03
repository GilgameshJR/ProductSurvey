package com.db2.productsurvey.memberzone.controllers;

import com.db2.productsurvey.beans.ProductServiceBean;
import com.db2.productsurvey.beans.QuestionnaireServiceBean;
import com.db2.productsurvey.entities.Questionnaire;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class Index extends HttpServlet {

    @EJB(name = "com.db2.productsurvey.beans/QuestionnaireServiceBean")
    private QuestionnaireServiceBean questionnaireService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Questionnaire todayQuestionnaire=questionnaireService.getTodayQuestionnaire();
        if (todayQuestionnaire!=null)
            req.setAttribute("product", questionnaireService.getTodayQuestionnaire().getProduct());
        req.getRequestDispatcher("/WEB-INF/memberzone/index.jsp").forward(req, res);
    }
}