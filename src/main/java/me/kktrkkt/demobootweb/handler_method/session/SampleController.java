package me.kktrkkt.demobootweb.handler_method.session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"hi"})
public class SampleController {

    @GetMapping("/session")
    @ResponseBody
    public void getSession(HttpSession session) {
        session.setAttribute("hello", "world");
    }

    @GetMapping("/session-attributes")
    public String getSessionAttributes(Model model) {
        // @SessionAttribute의 인자값과 모델의 애트리뷰트 명이 같으면 세션에 넣어준다
        model.addAttribute("hi", "bye");
        return "view/sample";
    }
}
