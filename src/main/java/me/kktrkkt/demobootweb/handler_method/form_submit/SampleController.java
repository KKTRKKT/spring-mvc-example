package me.kktrkkt.demobootweb.handler_method.form_submit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SampleController {

    // 이벤트 정보를 입력할 수 있는 뷰 반환
    @GetMapping("/events/form")
    public String getEventsForm(Model model) {
        Event attributeValue = new Event();
        attributeValue.setLimit(100);
        attributeValue.setName("name");
        model.addAttribute("event", attributeValue);
        return "event/form";
    }

    // 요청 param이 단순 타입일 때 @RequestParam으로 바로 받을 수 있다
    @PostMapping(value = "/events")
    @ResponseBody
    public Event postEvents(@RequestParam String name,
                            @RequestParam int limit){
        Event event = new Event();
        event.setName(name);
        event.setLimit(limit);
        return event;
    }

    // 요청 param과 복합 타입의 프로퍼티 명과 일치할 때 @ModelAttribute로 받을 수 있다
    @PostMapping(value = "/events/model")
    @ResponseBody
    public Event postEventsModel(@ModelAttribute Event event){
        return event;
    }

    // BindingResult를 추가하면 바인딩 에러를 직접 처리할 수 있다
    @PostMapping(value = "/events/br")
    @ResponseBody
    public Event postEventsBR(
                @ModelAttribute Event event,
                BindingResult bindingResult ){
        bindingResult.getAllErrors().forEach(System.out::println);
        return event;
    }

    // @Valid와 복합 객체의 프로퍼티에 붙어있는 검증 애노테이션을 통해 검증할 수 있다
    // (BindingResult를 추가하면 직접 에러 처리활 수 있다)
    @PostMapping(value = "/events/valid")
    @ResponseBody
    public Event postEventsValid(@Valid @ModelAttribute Event event){
        return event;
    }

    // spring에서 제공하는 검증으로 그룹을 지정해서 검증할 수 있다.
    // name만 검증
    @PostMapping(value = "/events/validated")
    @ResponseBody
    public Event postEventsValidated(@Validated(Event.NameValidation.class) @ModelAttribute Event event){
        return event;
    }

}
