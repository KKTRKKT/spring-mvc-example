package me.kktrkkt.demobootweb.handler_method.form_submit;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String getEventsForm(Model model) {
        model.addAttribute("event", new Event());
        return "event/form";
    }

    @PostMapping(value = "/events", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Event postEvents(@RequestBody Event event){
        return event;
    }

}
