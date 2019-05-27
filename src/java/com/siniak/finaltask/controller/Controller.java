package com.siniak.finaltask.controller;

import com.siniak.finaltask.command.Command;
import com.siniak.finaltask.command.CommandFactory;
import com.siniak.finaltask.connection.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.FORWARD;

@WebServlet(name = "Controller", urlPatterns = {"/controller"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public void destroy() {
        ConnectionPool.getInstance().shutdownPool();
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory factory = new CommandFactory();
        SessionRequestContent content = new SessionRequestContent();
        content.extractValues(request);
        Command command = factory.defineCommand(content);
        Router router = command.execute(content);
        content.insertValues(request);
        if (router.getPathType().toString().equals(FORWARD)) {
            getServletContext().getRequestDispatcher(router.getPage()).forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + router.getPage());
        }
    }
}
