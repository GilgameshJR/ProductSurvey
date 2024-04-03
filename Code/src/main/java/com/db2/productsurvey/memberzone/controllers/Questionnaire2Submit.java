package com.db2.productsurvey.memberzone.controllers;

import com.db2.productsurvey.Error;
import com.db2.productsurvey.*;
import com.db2.productsurvey.beans.ResponseSubmitServiceBean;
import com.db2.productsurvey.entities.SimpleUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class Questionnaire2Submit extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String ServletContext=req.getContextPath();
        ResponseSubmitServiceBean responseSubmitService = (ResponseSubmitServiceBean) session.getAttribute("responsebean");
        if (responseSubmitService == null || responseSubmitService.getMarketingAnswers() == null)
            res.sendRedirect("part1");
        else {
            try {
                String ageStr=req.getParameter("age");
                String sexStr=req.getParameter("sex");
                String experienceStr=req.getParameter("experience");

                Integer age=null;
                if (ageStr!=null && ageStr.length()>0) {
                    age = parseInt(ageStr);
                }
                Sex sex=null;
                if (sexStr!=null && sexStr.length()>0) {
                    sex=Sex.valueOf(sexStr.toUpperCase());
                }
                Experience experience=null;
                if (experienceStr!=null && experienceStr.length()>0) {
                    experience = Experience.valueOf(experienceStr.toUpperCase());
                }

                SimpleUser user = (SimpleUser) session.getAttribute("user");
                responseSubmitService.addPersonalAnswersAndStore(user, age, sex, experience);
                session.removeAttribute("responsebean");
            } catch (IllegalArgumentException e) {
                res.sendRedirect(req.getContextPath()+ ErrorUtils.getErrorPagePathFromContext(Error.ILLEGALPARAMETER));
                return;
            } catch (MissingAnswersException e) {
                res.sendRedirect("part1");
            }
            res.sendRedirect(ServletContext + "/memberzone/leaderboard");
        }
    }
}
