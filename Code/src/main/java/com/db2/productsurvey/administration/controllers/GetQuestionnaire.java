package com.db2.productsurvey.administration.controllers;

import com.db2.productsurvey.Error;
import com.db2.productsurvey.ErrorUtils;
import com.db2.productsurvey.beans.QuestionnaireServiceBean;
import com.db2.productsurvey.beans.ResponseServiceBean;
import com.db2.productsurvey.entities.Opening;
import com.db2.productsurvey.entities.Questionnaire;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class GetQuestionnaire extends HttpServlet {
    @EJB(name = "com.db2.productsurvey.beans/ResponseServiceBean")
    ResponseServiceBean responseService;
    @EJB(name = "com.db2.productsurvey.beans/QuestionnaireServiceBean")
    QuestionnaireServiceBean questionnaireService;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String dateStr=req.getParameter("date");
        if (dateStr==null || dateStr.trim().length()==0) {
            res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.MISSINGPARAMETER));
            return;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            LocalDate date = LocalDate.parse(dateStr, formatter);

            Questionnaire questionnaire = questionnaireService.getQuestionnaireByDate(date);
            if (questionnaire == null) {
                res.sendRedirect(req.getContextPath() + ErrorUtils.getErrorPagePathFromContext(Error.NOQUESTIONNAIRE));
                return;
            }
            req.setAttribute("questionnaire", questionnaire);

            if (date.isAfter(LocalDate.now()))
                req.setAttribute("future", true);
            else {
                req.setAttribute("future", false);
                List<Opening> unsubmissions = responseService.getUnsubmittingUsers(questionnaire.getId());
                req.setAttribute("unsubmissions", unsubmissions);
            }
            req.getRequestDispatcher("/WEB-INF/administration/questionnaire.jsp").forward(req, res);
        } catch (NumberFormatException | DateTimeParseException e) {
            res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.ILLEGALPARAMETER));
            return;
        }
    }
}