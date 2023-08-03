package me.kktrkkt.demobootweb.uri_pattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @RequestMapping("/{name:[a-z]+}")
    public String getName(@PathVariable("name") String name){
        return "sample " + name;
    }

    @RequestMapping("/kktrkkt")
    public String getKktrkkt(){
        return "kktrkkt";
    }
}
