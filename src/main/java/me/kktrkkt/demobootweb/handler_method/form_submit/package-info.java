package me.kktrkkt.demobootweb.handler_method.form_submit;

/*
http 요청의 본문이 application/x-www-form-urlencoded 타입일 때 처리 방법에 대해 알아본다.

- @RequestParam으로 Simple 타입을 하나씩 받는 방식
- @ModelAttribute로 복합 타입으로 한번에 받는 방식

바인딩 에러 관리
매개변수에 BindingResult 추가

파라미터 검증
- @Valid는 자바에서 지원
- @Validated 스프링에서 지원 검증 그룹화 가능

 */