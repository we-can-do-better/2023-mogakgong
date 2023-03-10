package hello.demo.web.frontcontroller.v3.controller;

import hello.demo.domain.member.Member;
import hello.demo.domain.member.MemberRepository;
import hello.demo.web.frontcontroller.ModelView;
import hello.demo.web.frontcontroller.v2.ControllerV2;
import hello.demo.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();


    @Override
    public ModelView process(Map<String, String> paraMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members",members);
        return mv;


    }
}
