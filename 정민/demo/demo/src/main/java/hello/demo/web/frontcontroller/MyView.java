package hello.demo.web.frontcontroller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

public class MyView {
    private String ViewPath;


    public MyView(String viewPath) {
        ViewPath = viewPath;
    }
    public void render(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(ViewPath);
        dispatcher.forward(request,response);
    }
}
