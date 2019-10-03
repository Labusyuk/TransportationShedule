package com.labus.showcase.controller;

import com.labus.showcase.action.Action;
import com.labus.showcase.action.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Action command = ActionFactory.defineAction(request);
        String result;
        result = command.execute(request, response);
        request.getRequestDispatcher("/views/"+result+".jsp").forward(request,response);
    }
}
