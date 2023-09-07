package me.kktrkkt.demobootweb.data_binder;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URI;

@Controller
@RequestMapping("/api/samples")
public class SampleController {

    // model에 sample이라는 애트리뷰트에만 해당 데이터바인더 로직을 적용한다
    @InitBinder("sample")
    public void initSampleBinder(WebDataBinder web){
        web.setDisallowedFields("id");
        web.setValidator(new SampleValidator());
    }

    @PostMapping
    public ResponseEntity<Sample> postSamples(@Valid @ModelAttribute Sample sample) {
        System.out.println("id : " + sample.getId());
        sample.setId(10L);
        return ResponseEntity.created(URI.create("/api/samples/10")).body(sample);
    }
}
