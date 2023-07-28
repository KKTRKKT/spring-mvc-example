package me.kktrkkt.demobootweb.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter implements Converter<String, Person> {

    @Override
    public Person convert(String source) {
        Person person = new Person();
        person.setId(Long.valueOf(source));
        return person;
    }
}
