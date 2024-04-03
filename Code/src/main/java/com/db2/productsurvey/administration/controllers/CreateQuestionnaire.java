package com.db2.productsurvey.administration.controllers;

import com.db2.productsurvey.Error;
import com.db2.productsurvey.ErrorUtils;
import com.db2.productsurvey.beans.QuestionnaireServiceBean;
import com.db2.productsurvey.entities.Question;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class CreateQuestionnaire extends HttpServlet {
    @EJB(name = "com.db2.productsurvey.beans/QuestionnaireServiceBean")
    QuestionnaireServiceBean questionnaireService;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String productStr=req.getParameter("product");
            String[] questionsStr=req.getParameterValues("q");
            String dateStr=req.getParameter("date");
            if (productStr == null || productStr.trim().length()==0 || questionsStr==null || questionsStr.length==0 || dateStr==null || dateStr.trim().length()==0) {
                res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.MISSINGPARAMETER));
                return;
            }
            int productId = parseInt(productStr);
            //check input validity
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            LocalDate date= LocalDate.parse(dateStr, formatter);
            if (date.isBefore(LocalDate.now())) {
                res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.ADMIN_CREATIONONPASTDATE));
                return;
            }
            List<Question> questions = new ArrayList<>();
            for (String q : questionsStr) {
                Question question = new Question();
                question.setQuestion(q);
                questions.add(question);
            }
            questionnaireService.createQuestionnaire(productId, questions, date);
            res.sendRedirect(req.getContextPath() + "/administration/getquestionnaire?date=" + dateStr.trim());
        } catch (DateTimeParseException | NumberFormatException e) {
            res.sendRedirect(req.getContextPath() + ErrorUtils.getErrorPagePathFromContext(Error.ILLEGALPARAMETER));
            return;
        } catch (EJBTransactionRolledbackException e) {
            res.sendRedirect(req.getContextPath() + ErrorUtils.getErrorPagePathFromContext(Error.ADMIN_QUESTIONNAIREALREADYEXIST));
            return;
        }
    }
}