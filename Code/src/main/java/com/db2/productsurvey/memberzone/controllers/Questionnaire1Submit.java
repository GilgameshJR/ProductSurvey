package com.db2.productsurvey.memberzone.controllers;

import com.db2.productsurvey.Error;
import com.db2.productsurvey.ErrorUtils;
import com.db2.productsurvey.beans.QuestionnaireServiceBean;
import com.db2.productsurvey.beans.ResponseServiceBean;
import com.db2.productsurvey.beans.ResponseSubmitServiceBean;
import com.db2.productsurvey.beans.UserServiceBean;
import com.db2.productsurvey.entities.Answer;
import com.db2.productsurvey.entities.Question;
import com.db2.productsurvey.entities.Questionnaire;
import com.db2.productsurvey.entities.SimpleUser;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class Questionnaire1Submit extends HttpServlet {
    @EJB(name = "com.db2.productsurvey.beans/QuestionnaireServiceBean")
    private QuestionnaireServiceBean questionnaireService;
    @EJB(name = "com.db2.productsurvey.beans/ResponseServiceBean")
    private ResponseServiceBean responseService;
    @EJB(name = "com.db2.productsurvey.beans/UserServiceBean")
    private UserServiceBean userService;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session=req.getSession(true);

        Questionnaire todayQuestionnaire=questionnaireService.getTodayQuestionnaire();
        List<Question> questions=todayQuestionnaire.getQuestions();
        List<Answer> answers=new ArrayList<>();
        for (Question question: questions) {
            String userAnswer=req.getParameter(((Integer) question.getId()).toString());
            if (userAnswer==null || userAnswer.trim().length() == 0) {
                res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.MISSINGPARAMETER));
                return;
            }
            //String[] words=userAnswer.split("( |,|.)+");
            String[] words=userAnswer.split("\\W+");
            for (String word:words) {
                if (responseService.isWordOffensive(word)) {
                    SimpleUser user=(SimpleUser)session.getAttribute("user");
                    user.setBlocked(true);
                    userService.updateUser(user);
                    session.removeAttribute("user");
                    res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.MEMBER_OFFENSIVEWORD));
                    return;
                }
            }
            Answer answer=new Answer();
            answer.setAnswer(userAnswer);
            answer.setQuestion(question);
            answers.add(answer);
        }

        ResponseSubmitServiceBean responseSubmitService = (ResponseSubmitServiceBean)session.getAttribute("responsebean");
        if (responseSubmitService == null) {
            try {
                InitialContext ctx = new InitialContext();
                responseSubmitService = (ResponseSubmitServiceBean) ctx.lookup("java:global/productsurvey/ResponseSubmitServiceBean");
                session.setAttribute("responsebean", responseSubmitService);
            } catch (NamingException e) {
                e.printStackTrace();
                res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.GENERICERROR));
                return;
            }
        }
        responseSubmitService.addMarketingAnswers(answers);
        res.sendRedirect("part2");
    }

}