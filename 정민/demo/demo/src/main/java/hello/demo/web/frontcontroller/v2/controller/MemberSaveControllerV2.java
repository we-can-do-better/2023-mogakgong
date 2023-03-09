package hello.demo.web.frontcontroller.v2.controller;

import hello.demo.domain.member.Member;
import hello.demo.domain.member.MemberRepository;
import hello.demo.web.frontcontroller.MyView;
import hello.demo.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member= new Member(username,age);

        memberRepository.save(member);


        request.setAttribute("member",member);



        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
