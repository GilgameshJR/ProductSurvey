package com.db2.productsurvey.memberzone.controllers;

import com.db2.productsurvey.beans.ResponseServiceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet//(name = "Servlet", value = "/memberzone")
public class Leaderboard extends HttpServlet {
    @EJB(name = "com.db2.productsurvey.beans/ResponseServiceBean")
    private ResponseServiceBean responseService;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setAttribute("responses",responseService.getResponseForQuestionnaireSortedByPoint(LocalDate.now()));
        req.getRequestDispatcher("/WEB-INF/memberzone/leaderboard.jsp").forward(req, res);
    }
}