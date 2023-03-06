package hello.demo.basic.response;

import hello.demo.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet",urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // status line
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);


        // [responseheader]
        response.setHeader("Content-type","text/plain;charset=utf-8");
        response.setHeader("Cache-Control","no-cache, no-stroe, must-revalidate");
        response.setHeader("Pragma","no-cache");
        response.setHeader("my-header","hello");

        PrintWriter writer= response.getWriter();
        writer.println("ok");
    }
}
