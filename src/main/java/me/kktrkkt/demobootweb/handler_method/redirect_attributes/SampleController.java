package me.kktrkkt.demobootweb.handler_method.redirect_attributes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController {

    @GetMapping("/form")
    public String getForm() {
        return "redirect/form";
    }

    @PostMapping("/form")
    public String postForm(String name, String limit, RedirectAttributes redirectAttributes) {
        // 리다이렉트 url 파라미터에 추가된다 /list?name={name}&limit={limit}
        redirectAttributes.addAttribute("name", name);
        redirectAttributes.addAttribute("limit", limit);
        return "redirect:/event";
    }

    @GetMapping("/event")
    public String getEvent(@RequestParam String name, @RequestParam String limit, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("limit", limit);
        return "redirect/event";
    }

    @GetMapping("/form/flash")
    public String getFormFlash() {
        return "redirect/form-flash";
    }

    @PostMapping("/form/flash")
    public String postFormFlash(String name, String limit, RedirectAttributes redirectAttributes) {
        // HttpSession을 통해 애트리뷰트를 넘겨주고 휘발된다
        redirectAttributes.addFlashAttribute("name", name);
        redirectAttributes.addFlashAttribute("limit", limit);
        return "redirect:/event/flash";
    }

    @GetMapping("/event/flash")
    public String getEventFlash() {
        // 이미 모델에 addFlashAttribute 값들이 들어있다.
        return "redirect/event";
    }
}
