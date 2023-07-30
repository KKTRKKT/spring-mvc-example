package me.kktrkkt.demobootweb.http_message_converter;

/*
HTTP 메세지 컨버터는 요청 본문의 메세지를 읽어들이거나, 응답 본문에 메세지를 작성할때 사용한다.
클라이언트/요청  -> HTTP 메세지 컨버터/요청 본문 변환 -> 핸들러/처리 후 결과 반환 -> HTTP 메세지 컨버터/응답 본문 변환 -> 클라이언트/응답확인

스프링 프레임워크 기본 HTTP 메세지 컨버터
- ByteArrayHttpMessageConverter - 이미지 파일등 바이너리 <-> 객체
- StringHttpMessageConverter - JSON, XML 등 텍스트 데이터 <-> 객체
- ResourceHttpMessageConverter - org.springframework.core.io.Resource 타입의 데이터 처리 -> 응답 리소스 전송(e.g 파일 다운로드)
- ResourceRegionHttpMessageConverter - org.springframework.core.io.support.ResourceRegion 타입의 대용량 데이터 처리 -> 응답
- SourceHttpMessageConverter - XML 형식 <-> 객체
- AllEncompassingFormHttpMessageConverter - application/x-www-form-urlencoded 미디어 타입 데이터 처리(html form) -> 객체

클래스패스가 존재하면 등록하는 컨버터
- JAXB2 - XML <-> 객체
- Jackson2 - JSON <-> 객체 // 스프링 부트의 웹 모듈에 존재함
- Jackson - Jackson2 호환 안될 경우 사용
- Gson - JSON <-> 객체
- Atom - atom 피드 <-> 객체
- RSS - RSS 피드 <-> 객체

xml 컨버터 dependency
<!--xml 메세지 컨버터 인터페이스 -->
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
</dependency>
<!-- xml 메세지 컨버터 구현체 -->
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
</dependency>
<!-- xml <-> 객체 변환 라이브러리 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-oxm</artifactId>
    <version>${spring-framework.version}</version>
</dependency>

HTTP 메세지 컨버터를 등록하기 위해서는 WebMvcConfigurer에서 아래 함수를 오버라이딩한다.
- configureMessageConverters() - 이 메세지를 오버라이딩하면 모든 컨버터가 사라진다.
- extendMessageConverters() - 기존 컨버터를 유지하면서 추가하고 싶을때 사용한다.
 */