package hello.demo.web.frontcontroller.v3.controller;

import hello.demo.domain.member.Member;
import hello.demo.domain.member.MemberRepository;
import hello.demo.web.frontcontroller.ModelView;
import hello.demo.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paraMap) {

        String username = paraMap.get("username");
        int age = Integer.parseInt(paraMap.get("age"));

        Member member = new Member(username,age);

        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member",member);

        return mv;
    }
}
