package com.sesearch.servlets;

import com.sesearch.models.StackExchangeRequest;
import com.sesearch.models.StackExchangeResponse;
import com.sesearch.services.StackExchangeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "StackExchangeController", urlPatterns = "/se")
public class StackExchangeController extends HttpServlet {

    StackExchangeService seService = new StackExchangeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
        String nextJSP = "/jsp/search-form.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
        String nextJSP = "/jsp/search-result.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.include(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        StackExchangeRequest searchRequest = getRequest(req);
        if (searchRequest.searchString != null && !searchRequest.searchString.isEmpty()) {
            StackExchangeResponse result = seService.search(searchRequest);
            req.setAttribute("questionList", result.items);
            req.setAttribute("hasmore", result.hasMore);
            req.setAttribute("searchString", searchRequest.searchString);
            req.setAttribute("sortfield", searchRequest.sortField);
        }
    }

    private void forwardQuestionList(HttpServletRequest req, HttpServletResponse resp, List questionList)
            throws ServletException, IOException {

    }

    private StackExchangeRequest getRequest(HttpServletRequest req) {
        int pagenum = tryParseInt(req.getParameter("pagenum"), 1);
        int pagesize = tryParseInt(req.getParameter("pagesize"), 30);
        String searchStr = req.getParameter("searchString");
        String sortField = req.getParameter("sortfield");

        return new StackExchangeRequest(searchStr, pagenum, pagesize, sortField);
    }

    private int tryParseInt(String value, int defaultVal) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }


}
