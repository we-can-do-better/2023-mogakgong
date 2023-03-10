package hello.demo.web.frontcontroller.v3.controller;

import hello.demo.web.frontcontroller.ModelView;
import hello.demo.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paraMap) {
        return new ModelView("new-form");

    }
}
