package me.kktrkkt.demobootweb.model_attribute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/samples/{id}")
public class SampleController {

    // 리턴값이 "sample" attribute명으로 모델에 저장된다
    @ModelAttribute("sample")
    public Sample findSample(@PathVariable("id") Long id) {
        Sample sample = new Sample();
        sample.setId(id);
        sample.setName("sample"+id);
        return sample;
    }

    // 모든 핸들러에 모델 정보가 추가된다
    @ModelAttribute
    public void apiVersion(Model model) {
        model.addAttribute("apiVersion", "1.0.0");
    }

    @GetMapping
    // 모델에 "sample" 애트리뷰트가 존재하면 바인딩해주고 없으면, 해당 객체를 모델에 추가해준다.
    public String getSample(@ModelAttribute("sample") Sample sample){
        System.out.println(sample.toString());
        return "/view/sample";
    }
}
