package me.kktrkkt.demobootweb.request_mapping.uri_pattern;

/*

스프링 프레임워크에서는 다양한 패턴을 통해 URI를 만들 수 있다.
*URL과 URN은 URI의 하위 개념으로 모두 URI라 불러도 된다. URL은 주소값으로 나타내는 식별자, URN은 이름으로 나타내는 식별자

요청식별자
- ?  - 한글자만 맵핑 e.g /sample? => /sample1
- *  - 여러글자 맵핑 e.g /sample/* => /sample/123
- ** - 여러패스 맵핑 e.g /sample** => /sample/many/path

기본 패턴 지정
Class에 @RequestMapping("/sample")이라 지정하면 메소드에서는 /sample 경로가 prefix로 붙여진것과 같은 효과

정규 표현식 사용 가능

패턴이 중복되는 경우에 가장 명확한 패턴에 맵핑 e.g /sample로 요청이 들어왔을떄 /**과 /sample이 있다면 /sample이 맵핑된다.

URI 확장자 맵핑 지원
e.g @GetMapping("/sample") => @GetMapping(value={"/sample", "/sample.*})
스프링부트에서는 사용불가하며, 권장하지 않는 기능이다. 확장자 다운로드를 통한 RFD Attack이 가능하기 때문
 */