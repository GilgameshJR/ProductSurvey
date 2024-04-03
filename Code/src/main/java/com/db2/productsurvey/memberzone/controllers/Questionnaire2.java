package com.db2.productsurvey.memberzone.controllers;

import com.db2.productsurvey.beans.ResponseSubmitServiceBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class Questionnaire2 extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ResponseSubmitServiceBean responseSubmitService = (ResponseSubmitServiceBean)req.getSession(true).getAttribute("responsebean");
        if (responseSubmitService==null || responseSubmitService.getMarketingAnswers()==null)
            res.sendRedirect("part1");
        else
            req.getRequestDispatcher("/WEB-INF/memberzone/questionnaire/part2.jsp").forward(req, res);
    }
}