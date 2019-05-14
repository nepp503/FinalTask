package com.siniak.finaltask.controller;

import com.siniak.finaltask.command.Command;
import com.siniak.finaltask.command.CommandFactory;
import com.siniak.finaltask.command.Router;
import com.siniak.finaltask.utils.SessionRequestContent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.siniak.finaltask.constant.Constant.USER_ATTR;


@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = null;
        CommandFactory factory = new CommandFactory();
        SessionRequestContent content = new SessionRequestContent();
        content.extractValues(request);
        Command command = factory.defineCommand(content);
        router = command.execute(content);
        content.insertValues(request);
        if (router.getPathType().toString().equals("FORWARD")) {
            request.getRequestDispatcher(router.getPage()).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + router.getPage());
        }
    }
}
