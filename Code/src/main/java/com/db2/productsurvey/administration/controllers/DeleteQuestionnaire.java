package com.db2.productsurvey.administration.controllers;

import com.db2.productsurvey.Error;
import com.db2.productsurvey.ErrorUtils;
import com.db2.productsurvey.beans.QuestionnaireServiceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeParseException;

import static java.lang.Integer.parseInt;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class DeleteQuestionnaire extends HttpServlet {
    @EJB(name = "com.db2.productsurvey.beans/QuestionnaireServiceBean")
    QuestionnaireServiceBean questionnaireService;
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String idStr=req.getParameter("id");
            if (idStr==null || idStr.trim().length()==0) {
                res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.MISSINGPARAMETER));
                return;
            }
            int id=parseInt(idStr);
            questionnaireService.deleteQuestionnaire(id);
            res.sendRedirect(req.getContextPath()+"/administration");
        } catch (NumberFormatException | DateTimeParseException e) {
            res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.ILLEGALPARAMETER));
            return;
        }
    }
}