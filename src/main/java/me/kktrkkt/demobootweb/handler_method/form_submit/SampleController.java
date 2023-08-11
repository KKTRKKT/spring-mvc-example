package me.kktrkkt.demobootweb.handler_method.form_submit;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String getEventsForm(Model model) {
        Event attributeValue = new Event();
        attributeValue.setLimit(100);
        attributeValue.setName("name");
        model.addAttribute("event", attributeValue);
        return "event/form";
    }

    @PostMapping(value = "/events")
    @ResponseBody
    public Event postEvents(@RequestParam String name,
                            @RequestParam int limit){
        Event event = new Event();
        event.setName(name);
        event.setLimit(limit);
        return event;
    }

}
