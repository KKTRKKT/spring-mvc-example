package me.kktrkkt.demobootweb.request_mapping.custom_mapping_annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;
import java.lang.invoke.MethodHandleInfo;

// @Documented 이 애노테이션을 사용한 코드의 문서에 해당 애노테이션 정보를 표기함
@Documented
// @Target 애노테이션을 어디에 사용할지 지정함
@Target({ElementType.TYPE})
// @Retention 언제까지 애노테이션을 유지할것인지 source: 컴파일 전, class: 런타임 전, runtime : 런타임까지
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(value = "/sample", method = RequestMethod.GET)
public @interface GetSampleMapping {
}
