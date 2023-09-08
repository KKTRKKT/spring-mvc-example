package me.kktrkkt.demobootweb.controller_advice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/samples/form")
    public String getSampleForm() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

    @GetMapping("/api/samples")
    public ResponseEntity<?> getSample() throws SampleException {
        throw new SampleException();
    }
}
