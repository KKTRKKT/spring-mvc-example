package me.kktrkkt.demobootweb.handler_method.session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"name", "limit"})
public class FormController {

    @GetMapping("/form1")
    public String getForm1() {
        return "session/form1";
    }

    @PostMapping("/form1")
    public String postForm1(String name, Model model){
        // session에 추가하려면 attributeName 필수
        model.addAttribute("name", name);
        return "redirect:/form2";
    }

    @GetMapping("/form2")
    public String getForm2() {
        return "session/form2";
    }

    @PostMapping("/form2")
    public String postForm2(int limit, Model model) {
        model.addAttribute("limit", limit);
        return "redirect:/last";
    }

    @GetMapping("/last")
    public String getLast(@SessionAttribute String name,
                          @SessionAttribute int limit,
                          @ModelAttribute Event event,
                          Model model,
                          SessionStatus sessionStatus) {
        event.setName(name);
        event.setLimit(limit);
        model.addAttribute(event);

        //session을 비워준다.
        sessionStatus.setComplete();
        return "session/last";
    }
}
