package hello.demo.web.frontcontroller.v2;

import hello.demo.web.frontcontroller.MyView;
import hello.demo.web.frontcontroller.v1.ControllerV1;
import hello.demo.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.demo.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.demo.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import hello.demo.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.demo.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.demo.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");

        String requestURI = request.getRequestURI();
        // requestURI는

        ControllerV2 controller = controllerMap.get(requestURI);
        // 컨트롤러가찾아짐


        // 예외처리 부분
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }


        MyView view =  controller.process(request, response);
        view.render(request,response);
    }
}
