package me.kktrkkt.demobootweb.handler_method.argument;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

@RestController
public class SampleController {

    @GetMapping("/sample/{id}")
    public boolean getSample(
            WebRequest webRequest,
            NativeWebRequest nativeWebRequest,
            HttpServletRequest httpServletRequest,
            InputStream inputStream,
//            Reader reader,
            OutputStream outputStream,
//            Writer writer,
            Locale locale,
            TimeZone timeZone,
            ZoneId zoneId,
            @RequestHeader("header") String header,
            @RequestParam("param") String param,
            @PathVariable("id") String id
            ) {
        ArrayList<Object> springSupportArguments = new ArrayList<>(12);
        springSupportArguments.add(webRequest);
        springSupportArguments.add(nativeWebRequest);
        springSupportArguments.add(httpServletRequest);
        springSupportArguments.add(inputStream);
//        springSupportArguments.add(reader);
        springSupportArguments.add(outputStream);
//        springSupportArguments.add(writer);
        springSupportArguments.add(locale);
        springSupportArguments.add(timeZone);
        springSupportArguments.add(zoneId);
        springSupportArguments.add(nativeWebRequest);

        System.out.println(header);
        System.out.println(param);
        System.out.println(id);

        springSupportArguments.forEach(System.out::println);
        return springSupportArguments.stream().allMatch(Objects::nonNull);
    }
}
