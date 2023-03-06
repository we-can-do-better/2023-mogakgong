package hello.demo.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 1. 파리미터 전송 기능
// /request-param?userane=hello&age=20
@WebServlet(name= "requestParamServlet",urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("[전체 파라미터 조화] - start");


        request.getParameterNames().asIterator()
                .forEachRemaining(paraName -> System.out.println(paraName + "=" + request.getParameter(paraName)));

        System.out.println("[전체 파리미터 존회] - end ");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username= request.getParameter("username");
        String age= request.getParameter("age");
        System.out.println("name = " + username);
        System.out.println("age = "+ age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미티ㅓ ]");
        String[] username1 = request.getParameterValues("username");
        for (String user : username1){
            System.out.println("u sernames:"+ user);
        }


        response.getWriter().write("ok");

    }
}
