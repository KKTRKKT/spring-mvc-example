package me.kktrkkt.demobootweb.handler_method.argument;

/*

핸들러 메소드에서 지원하는 아큐먼트에 대해 알아본다.

요청 및 응답 자체 타입
- WebRequest
- NativeWebRequest
- ServletRequest(Response) HttpServletRequest(Response)

요청 및 응답 본문 접근 타입
- InputStream
- Reader
- OutputStream
- Writer

클라이언트 위치 관련 타입
- Locale
- TimeZone
- ZoneId

URI 템플릿 변수를 읽을 때
@PathVariable

URI 경로 중 키/값 쌍으로 읽을 때
@MatrixVariable

요청 매개변수를 조회할 때, 단순 타입이면 생략가능
@RequestParam

요청 헤더 값을 조회할 때
@RequestHeader

그 외
https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-arguments

 */