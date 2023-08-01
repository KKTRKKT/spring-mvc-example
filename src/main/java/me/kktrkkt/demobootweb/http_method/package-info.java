package me.kktrkkt.demobootweb.http_method;

/*
HTTP Method에는 GET, POST, PUT, PATCH, DELETE 등이 있다.

GET
서버의 리소스를 요청할 떄 사용한다. 서버에 보내는 데이터가 URL에 보여진다.
- 캐싱 : 브라우저가 요청의 본문을 캐싱해 똑같은 요청에 캐싱값을 반환할 수 있다.
- 로깅 : 브라우저 기록에 남는다.
- 북마크 : 요청을 북마크할 수 있다
- 멱등성(idemponent) : 요청의 결과가 항상 똑같음

e.g
get /sample/1 -> { "id":"1", "title"="sample" } // 항상 결과가 똑같다

POST
지정된 리소스로 데이터를 제출하여 서버에 새로운 리소스를 생성하는데 사용한다. 서버에 보내는 데이터는 요청의 본문에 담긴다
- 캐싱 X
- 로깅 X
- 북마크 X
- 멱등성 X

e.g
post /sample, { "title"="sample" } -> { "id":"1", "title"="sample" }
             -> { "id":"2", "title"="sample" }
             ...    // 같은 요청에 결과가 항상 달라질 수 있다.

PUT
기존 리소스를 전체적으로 수정할 때 사용한다.
- 캐싱 X
- 로깅 X
- 북마크 X
- 멱등성 O

e.g
put /sample/1, { "id"="1" "title"="updated sample" } -> { "id":"1", "title"="updated sample" } // 항상 결과가 똑같다

PATCH
기존 리소스를 부분적으로 수정할 때 사용한다.
- 캐싱 X
- 로깅 X
- 북마크 X
- 멱등성 X

e.g
patch /sample/1, { "title"="sample" } // 서버 처리에 따라 리소스 결과가 달라질 수 있다

DELETE
특정 리소스를 삭제할 때 사용한다.
- 캐싱 X
- 로깅 X
- 북마크 X
- 멱등성 O

DELETE /sample/1 // 해당 리소스가 없어진다는 결과는 똑같다

컨트롤러에 전체적으로 기본 RequestMapping 설정을 주고 싶으면 클래스에 애노테이션 부착
e.g
@Controller
@RequestMapping(option..)
Class blabla{...}

 */