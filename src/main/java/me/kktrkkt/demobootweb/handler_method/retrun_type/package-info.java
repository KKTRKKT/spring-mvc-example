package me.kktrkkt.demobootweb.handler_method.retrun_type;

/*

핸들러 메소드 반환값 관련 애노테이션 및 객체에 대해 알아본다.

@ResponseBody
메소드의 반환값을 응답 본문으로 되게 설정해준다. 반환값은  HttpMessageConverter를 거쳐서 변환될 수 있다.

응답 본문, 상태 및 헤더등 응답 전체 설정 타입
- ResponseEntity
- HttpEntity

뷰를 반환하는 경우
- String - viewResolver를 통해 이름에 해당하는 view(html, jsp 등)를 찾는다
- View - 해당하는 view를 반환
- Model - 모델만 반환하는 경우 RequestToViewNameTranslator를 이용해 uri 명을 기반으로 View를 찾는다


 */