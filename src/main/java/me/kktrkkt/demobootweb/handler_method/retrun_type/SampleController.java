package me.kktrkkt.demobootweb.handler_method.retrun_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@Controller
public class SampleController {

    @Autowired
    private ViewResolver viewResolver;

    @GetMapping("/response-body/sample")
    @ResponseBody
    public String getSampleResponseBody() {
        return "hello sample";
    }

    @GetMapping("/view/sample/string")
    public String getSampleString() {
        return "/view/sample";
    }

    @GetMapping("/view/sample/view")
    public View getSampleView(Locale locale) throws Exception {
        return viewResolver.resolveViewName("view/sample", locale);
    }

    @GetMapping("/view/sample/model")
    public Model getSampleModel(Model model) throws Exception {
        model.addAttribute("attribute", "attribute");
        return model;
    }
}
