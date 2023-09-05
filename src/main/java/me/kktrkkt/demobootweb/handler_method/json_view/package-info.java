package me.kktrkkt.demobootweb.handler_method.json_view;

/*
객체의 특정 속성만 그룹화해 json으로 변환할 수 있는 기능인 @JsonView에 대해 알아본다

@JsonView를 사용하기 위해서는 Mapper.DEFAULT_VIEW_INCLUSION=Disabled 설정 되어야 한다.
스프링부트에서는 자동설정에서 이미 Disabled 되어 있다(spring.jackson.mapper.default-view-inclusion=false)
*/