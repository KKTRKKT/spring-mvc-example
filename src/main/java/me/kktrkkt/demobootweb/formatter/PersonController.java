package me.kktrkkt.demobootweb.formatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/person/{name}")
    public String getPerson(@PathVariable("name") Person person){
        return person.toString();
    }
}
