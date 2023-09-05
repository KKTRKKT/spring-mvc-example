package me.kktrkkt.demobootweb.handler_method.json_view;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/samples")
public class SampleController {

    private static final List<Sample> samples = new ArrayList<>();

    static {
        Sample sample1 = new Sample();
        sample1.setId(1L);
        sample1.setName("sample1");
        sample1.setDetails("details1");
        Sample sample2 = new Sample();
        sample2.setId(2L);
        sample2.setName("sample2");
        sample2.setDetails("details2");
        samples.add(sample1);
        samples.add(sample2);
    }

    @GetMapping
    @JsonView(SampleJson.List.class)
    public List<Sample> getSampleList() {
        return samples;
    }

    @GetMapping("/{id}")
    @JsonView(SampleJson.Details.class)
    public Sample getSampleList(@PathVariable("id") Long id) {
        return samples.stream()
                .filter(x->id.equals(x.getId()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

}
