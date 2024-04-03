package com.db2.productsurvey.memberzone.controllers;

import com.db2.productsurvey.beans.QuestionnaireServiceBean;
import com.db2.productsurvey.beans.ResponseServiceBean;
import com.db2.productsurvey.beans.ResponseSubmitServiceBean;
import com.db2.productsurvey.entities.Answer;
import com.db2.productsurvey.entities.Questionnaire;
import com.db2.productsurvey.entities.SimpleUser;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet
public class Questionnaire1 extends HttpServlet {
    @EJB(name = "com.db2.productsurvey.beans/QuestionnaireServiceBean")
    private QuestionnaireServiceBean questionnaireService;
    @EJB(name = "com.db2.productsurvey.beans/ResponseServiceBean")
    private ResponseServiceBean responseService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Questionnaire todayQuestionnaire=questionnaireService.getTodayQuestionnaire();
        req.setAttribute("questionnaire", todayQuestionnaire);

        HttpSession session=req.getSession(true);
        ResponseSubmitServiceBean responseSubmitService = (ResponseSubmitServiceBean)session.getAttribute("responsebean");
        if (responseSubmitService != null && responseSubmitService.getMarketingAnswers()!=null)
            req.setAttribute("previousanswers", responseSubmitService.getMarketingAnswers());

        responseService.storeUserOpeningTodayQuestionnaire((SimpleUser)session.getAttribute("user"));

        req.getRequestDispatcher("/WEB-INF/memberzone/questionnaire/part1.jsp").forward(req, res);
    }
}
