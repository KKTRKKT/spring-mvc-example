# spring-mvc-example

Spring MVC의 다양한 기능들을 예제로 학습하는 프로젝트입니다.

## 목차 (Table of Contents)

1. [HTTP Method](#1-http-method)
2. [Request Mapping](#2-request-mapping)
   - [URI Pattern](#21-uri-pattern)
   - [HTTP Parameter](#22-http-parameter)
   - [HTTP Header](#23-http-header)
   - [Media Type](#24-media-type)
   - [HTTP Message Converter](#25-http-message-converter)
   - [Head and Options](#26-head-and-options)
   - [Custom Mapping Annotation](#27-custom-mapping-annotation)
3. [Handler Method](#3-handler-method)
   - [Argument](#31-argument)
   - [Return Type](#32-return-type)
   - [Request Parsing](#33-request-parsing)
   - [Response Converting](#34-response-converting)
   - [Form Submit](#35-form-submit)
   - [Multipart File](#36-multipart-file)
   - [Redirect Attributes](#37-redirect-attributes)
   - [Session](#38-session)
   - [JSON View](#39-json-view)
4. [Model Attribute](#4-model-attribute)
5. [Data Binder](#5-data-binder)
6. [Converter](#6-converter)
7. [Formatter](#7-formatter)
8. [Exception Handler](#8-exception-handler)
9. [Controller Advice](#9-controller-advice)
10. [Interceptor](#10-interceptor)
11. [Resource Handler](#11-resource-handler)

---

## 1. HTTP Method

**패키지**: `me.kktrkkt.demobootweb.http_method`

HTTP Method에는 GET, POST, PUT, PATCH, DELETE 등이 있습니다.

### GET
서버의 리소스를 요청할 때 사용합니다. 서버에 보내는 데이터가 URL에 보여집니다.
- **캐싱**: 브라우저가 요청의 본문을 캐싱해 똑같은 요청에 캐싱값을 반환할 수 있습니다
- **로깅**: 브라우저 기록에 남습니다
- **북마크**: 요청을 북마크할 수 있습니다
- **멱등성(idempotent)**: 요청의 결과가 항상 똑같습니다

예시:
```
GET /sample/1 → { "id":"1", "title":"sample" } // 항상 결과가 똑같다
```

### POST
지정된 리소스로 데이터를 제출하여 서버에 새로운 리소스를 생성하는데 사용합니다. 서버에 보내는 데이터는 요청의 본문에 담깁니다.
- 캐싱 ✗
- 로깅 ✗
- 북마크 ✗
- 멱등성 ✗

예시:
```
POST /sample, { "title":"sample" } → { "id":"1", "title":"sample" }
                                    → { "id":"2", "title":"sample" }
// 같은 요청에 결과가 항상 달라질 수 있다
```

### PUT
기존 리소스를 전체적으로 수정할 때 사용합니다.
- 캐싱 ✗
- 로깅 ✗
- 북마크 ✗
- 멱등성 ✓

예시:
```
PUT /sample/1, { "id":"1", "title":"updated sample" } 
→ { "id":"1", "title":"updated sample" } // 항상 결과가 똑같다
```

### PATCH
기존 리소스를 부분적으로 수정할 때 사용합니다.
- 캐싱 ✗
- 로깅 ✗
- 북마크 ✗
- 멱등성 ✗

예시:
```
PATCH /sample/1, { "title":"sample" } // 서버 처리에 따라 리소스 결과가 달라질 수 있다
```

### DELETE
특정 리소스를 삭제할 때 사용합니다.
- 캐싱 ✗
- 로깅 ✗
- 북마크 ✗
- 멱등성 ✓

예시:
```
DELETE /sample/1 // 해당 리소스가 없어진다는 결과는 똑같다
```

**팁**: 컨트롤러에 전체적으로 기본 RequestMapping 설정을 주고 싶으면 클래스에 애노테이션을 부착합니다.
```java
@Controller
@RequestMapping(option..)
class SampleController {...}
```

---

## 2. Request Mapping

### 2.1 URI Pattern

**패키지**: `me.kktrkkt.demobootweb.request_mapping.uri_pattern`

스프링 프레임워크에서는 다양한 패턴을 통해 URI를 만들 수 있습니다.

#### 요청 식별자
- `?` - 한 글자만 매핑 (예: `/sample?` → `/sample1`)
- `*` - 여러 글자 매핑 (예: `/sample/*` → `/sample/123`)
- `**` - 여러 패스 매핑 (예: `/sample**` → `/sample/many/path`)

#### 기본 패턴 지정
클래스에 `@RequestMapping("/sample")`이라 지정하면 메소드에서는 `/sample` 경로가 prefix로 붙여진 것과 같은 효과가 있습니다.

#### 정규 표현식
정규 표현식 사용이 가능합니다.

#### 패턴 우선순위
패턴이 중복되는 경우에 가장 명확한 패턴에 매핑됩니다. 
예: `/sample`로 요청이 들어왔을 때 `/**`과 `/sample`이 있다면 `/sample`이 매핑됩니다.

#### URI 확장자 매핑 (권장하지 않음)
예: `@GetMapping("/sample")` → `@GetMapping(value={"/sample", "/sample.*})`

스프링부트에서는 사용불가하며, 권장하지 않는 기능입니다. 확장자 다운로드를 통한 RFD Attack이 가능하기 때문입니다.

**참고**: URL과 URN은 URI의 하위 개념으로 모두 URI라 불러도 됩니다. URL은 주소값으로 나타내는 식별자, URN은 이름으로 나타내는 식별자입니다.

---

### 2.2 HTTP Parameter

**패키지**: `me.kktrkkt.demobootweb.request_mapping.http_param`

파라미터를 이용해 요청을 매핑하는 방법을 알아봅니다.

요청 파라미터를 사용하여 더 세밀한 요청 매핑이 가능합니다.

---

### 2.3 HTTP Header

**패키지**: `me.kktrkkt.demobootweb.request_mapping.http_header`

헤더를 이용해 요청을 매핑하는 방법을 알아봅니다.

HTTP 헤더 값을 기반으로 요청을 처리할 핸들러를 결정할 수 있습니다.

---

### 2.4 Media Type

**패키지**: `me.kktrkkt.demobootweb.request_mapping.media_type`

미디어 타입은 데이터 형식의 표준화된 식별자입니다. 일반적으로 MIME 형식으로 표현됩니다.

#### MIME 예시
- `text/plain` - 일반 텍스트
- `application/json` - JSON 형식의 데이터
- `image/jpeg` - JPEG 형식의 이미지

Content-Type과 Accept 헤더를 사용하여 요청과 응답의 미디어 타입을 지정할 수 있습니다.

---

### 2.5 HTTP Message Converter

**패키지**: `me.kktrkkt.demobootweb.request_mapping.http_message_converter`

HTTP 메시지 컨버터는 요청 본문의 메시지를 읽어들이거나, 응답 본문에 메시지를 작성할 때 사용합니다.

**처리 흐름**:
```
클라이언트/요청 
→ HTTP 메시지 컨버터/요청 본문 변환 
→ 핸들러/처리 후 결과 반환 
→ HTTP 메시지 컨버터/응답 본문 변환 
→ 클라이언트/응답확인
```

#### 스프링 프레임워크 기본 HTTP 메시지 컨버터
- `ByteArrayHttpMessageConverter` - 이미지 파일 등 바이너리 ↔ 객체
- `StringHttpMessageConverter` - JSON, XML 등 텍스트 데이터 ↔ 객체
- `ResourceHttpMessageConverter` - `org.springframework.core.io.Resource` 타입의 데이터 처리 → 응답 리소스 전송 (예: 파일 다운로드)
- `ResourceRegionHttpMessageConverter` - `org.springframework.core.io.support.ResourceRegion` 타입의 대용량 데이터 처리 → 응답
- `SourceHttpMessageConverter` - XML 형식 ↔ 객체
- `AllEncompassingFormHttpMessageConverter` - `application/x-www-form-urlencoded` 미디어 타입 데이터 처리 (HTML form) → 객체

#### 클래스패스가 존재하면 등록하는 컨버터
- **JAXB2** - XML ↔ 객체
- **Jackson2** - JSON ↔ 객체 (스프링 부트의 웹 모듈에 존재)
- **Jackson** - Jackson2 호환 안 될 경우 사용
- **Gson** - JSON ↔ 객체
- **Atom** - Atom 피드 ↔ 객체
- **RSS** - RSS 피드 ↔ 객체

#### XML 컨버터 의존성
```xml
<!--xml 메시지 컨버터 인터페이스 -->
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
</dependency>
<!-- xml 메시지 컨버터 구현체 -->
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
```

#### HTTP 메시지 컨버터 등록
`WebMvcConfigurer`에서 아래 함수를 오버라이딩합니다:
- `configureMessageConverters()` - 이 메소드를 오버라이딩하면 모든 컨버터가 사라집니다
- `extendMessageConverters()` - 기존 컨버터를 유지하면서 추가하고 싶을 때 사용합니다

---

### 2.6 Head and Options

**패키지**: `me.kktrkkt.demobootweb.request_mapping.head_and_options`

HEAD와 OPTIONS는 HTTP method의 일종입니다:
- **HEAD** 요청 - 본문 없이 결과를 리턴해줍니다
- **OPTIONS** 요청 - 본문 없이 Allow(사용 가능한 메소드)만 가져옵니다

스프링에서는 핸들러를 구현하면 자동으로 추가해주기 때문에 따로 HEAD와 OPTIONS 핸들러를 만들지 않아도 됩니다.

---

### 2.7 Custom Mapping Annotation

**패키지**: `me.kktrkkt.demobootweb.request_mapping.custom_mapping_annotation`

커스텀한 매핑 애노테이션을 만드는 방법을 알아봅니다.

`@RequestMapping`을 메타 애노테이션으로 사용하여 자신만의 매핑 애노테이션을 정의할 수 있습니다.

---

## 3. Handler Method

### 3.1 Argument

**패키지**: `me.kktrkkt.demobootweb.handler_method.argument`

핸들러 메소드에서 지원하는 아규먼트에 대해 알아봅니다.

#### 요청 및 응답 자체 타입
- `WebRequest`
- `NativeWebRequest`
- `ServletRequest(Response)`
- `HttpServletRequest(Response)`

#### 요청 및 응답 본문 접근 타입
- `InputStream`
- `Reader`
- `OutputStream`
- `Writer`

#### 클라이언트 위치 관련 타입
- `Locale`
- `TimeZone`
- `ZoneId`

#### URI 템플릿 변수를 읽을 때
`@PathVariable`

#### URI 경로 중 키/값 쌍으로 읽을 때
`@MatrixVariable`

#### 요청 매개변수를 조회할 때
`@RequestParam` (단순 타입이면 생략 가능)

#### 요청 헤더 값을 조회할 때
`@RequestHeader`

**참고**: [Spring Framework 공식 문서](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-arguments)

---

### 3.2 Return Type

**패키지**: `me.kktrkkt.demobootweb.handler_method.retrun_type`

핸들러 메소드 반환값 관련 애노테이션 및 객체에 대해 알아봅니다.

#### @ResponseBody
메소드의 반환값을 응답 본문으로 되게 설정해줍니다. 반환값은 `HttpMessageConverter`를 거쳐서 변환될 수 있습니다.

#### 응답 본문, 상태 및 헤더 등 응답 전체 설정 타입
- `ResponseEntity`
- `HttpEntity`

#### 뷰를 반환하는 경우
- `String` - `viewResolver`를 통해 이름에 해당하는 view(HTML, JSP 등)를 찾습니다
- `View` - 해당하는 view를 반환합니다
- `Model` - 모델만 반환하는 경우 `RequestToViewNameTranslator`를 이용해 URI 명을 기반으로 View를 찾습니다

---

### 3.3 Request Parsing

**패키지**: `me.kktrkkt.demobootweb.handler_method.request_parsing`

`@RequestBody`와 `HttpEntity`를 이용해 요청 본문을 파싱하는 방법을 알아봅니다.

HTTP 메시지 컨버터를 사용하여 요청 본문의 데이터를 객체로 변환할 수 있습니다.

---

### 3.4 Response Converting

**패키지**: `me.kktrkkt.demobootweb.handler_method.response_converting`

응답 본문을 `@ResponseBody`와 `ResponseEntity`를 이용해 객체를 JSON으로 컨버팅하는 방법에 대해 알아봅니다.

HTTP 메시지 컨버터를 사용하여 객체를 JSON, XML 등의 형식으로 변환하여 응답할 수 있습니다.

---

### 3.5 Form Submit

**패키지**: `me.kktrkkt.demobootweb.handler_method.form_submit`

HTTP 요청의 본문이 `application/x-www-form-urlencoded` 타입일 때 처리 방법에 대해 알아봅니다.

#### 데이터 받는 방식
- `@RequestParam`으로 Simple 타입을 하나씩 받는 방식
- `@ModelAttribute`로 복합 타입으로 한 번에 받는 방식

#### 바인딩 에러 관리
매개변수에 `BindingResult` 추가

#### 파라미터 검증
- `@Valid` - 자바에서 지원
- `@Validated` - 스프링에서 지원, 검증 그룹화 가능

---

### 3.6 Multipart File

**패키지**: `me.kktrkkt.demobootweb.handler_method.multipart_file`

파일 업로드에 사용하는 `MultipartFile`과 `MultipartResolver`에 대해 알아봅니다.

`DispatcherServlet`의 기본 전략은 사용하지 않지만, Spring Boot는 `MultipartAutoConfiguration`에서 등록해줍니다.

---

### 3.7 Redirect Attributes

**패키지**: `me.kktrkkt.demobootweb.handler_method.redirect_attributes`

`RedirectAttributes`에 대해서 알아봅니다.

- `addAttribute()` - URL 파라미터에 인자를 전달합니다
- `addFlashAttribute()` - `HttpSession`을 통해 모델을 전달합니다. 전달 후에는 `HttpSession`에서 값이 휘발됩니다

---

### 3.8 Session

**패키지**: `me.kktrkkt.demobootweb.handler_method.session`

HTTP Session을 다루는 방법에 대해 알아봅니다.

세션을 사용하여 사용자의 상태 정보를 서버에 저장하고 관리할 수 있습니다.

---

### 3.9 JSON View

**패키지**: `me.kktrkkt.demobootweb.handler_method.json_view`

객체의 특정 속성만 그룹화해 JSON으로 변환할 수 있는 기능인 `@JsonView`에 대해 알아봅니다.

#### 설정
`@JsonView`를 사용하기 위해서는 `Mapper.DEFAULT_VIEW_INCLUSION=Disabled` 설정이 되어야 합니다.
스프링부트에서는 자동설정에서 이미 Disabled 되어 있습니다 (`spring.jackson.mapper.default-view-inclusion=false`).

---

## 4. Model Attribute

**패키지**: `me.kktrkkt.demobootweb.model_attribute`

모델값을 더 편하게 사용할 수 있는 `@ModelAttribute`에 대해 알아봅니다.

`@ModelAttribute`를 사용하면 요청 파라미터를 객체로 바인딩하거나, 모든 핸들러 메소드에서 공통으로 사용할 모델 데이터를 추가할 수 있습니다.

---

## 5. Data Binder

**패키지**: `me.kktrkkt.demobootweb.data_binder`

`@InitBinder`를 사용하여 데이터 바인딩 과정을 커스터마이징하는 방법을 알아봅니다.

데이터 바인더를 통해:
- 특정 필드를 바인딩에서 제외할 수 있습니다
- 커스텀 Validator를 등록할 수 있습니다
- 타입 변환 규칙을 설정할 수 있습니다

---

## 6. Converter

**패키지**: `me.kktrkkt.demobootweb.converter`

Converter는 객체를 다른 객체로 변환해주는 클래스입니다.

`Converter<S, T>` 인터페이스를 구현해 빈으로 등록해서 사용합니다.
S 타입을 T 타입으로 변환합니다.

예를 들어, 문자열로 전달된 "이름,나이" 형식의 데이터를 Person 객체로 변환할 수 있습니다.

---

## 7. Formatter

**패키지**: `me.kktrkkt.demobootweb.formatter`

Formatter는 문자열을 객체로, 객체를 문자열로 변환해주는 클래스입니다.

`Formatter<T>` 인터페이스를 구현해 빈으로 등록해 사용합니다.
문자열을 T 타입으로, T 타입을 문자열로 변환하는 함수 두 개를 구현합니다.

Converter와 유사하지만, Formatter는 문자열과 객체 간의 변환에 특화되어 있으며 로케일 정보를 활용할 수 있습니다.

---

## 8. Exception Handler

**패키지**: `me.kktrkkt.demobootweb.exception_handler`

예외를 처리하는 `@ExceptionHandler`에 대해 알아봅니다.

컨트롤러 내에서 발생하는 특정 예외를 처리하는 메소드를 정의할 수 있습니다. 이를 통해 예외 상황에 따라 적절한 응답을 반환할 수 있습니다.

---

## 9. Controller Advice

**패키지**: `me.kktrkkt.demobootweb.controller_advice`

`@InitBinder`, `@ModelAttribute`, `@ExceptionHandler` 등을 여러 컨트롤러에 한 번에 적용할 수 있는 `@ControllerAdvice`에 대해 알아봅니다.

`@ControllerAdvice`를 사용하면 전역적으로 적용되는:
- 예외 처리
- 데이터 바인딩 설정
- 모델 데이터 추가

등을 구현할 수 있습니다.

---

## 10. Interceptor

**패키지**: `me.kktrkkt.demobootweb.intercepter`

인터셉터는 핸들러 매핑에 따라 결정되는 핸들러를 실행하기 전, 후 그리고 렌더링 완료 후에 부가 작업을 할 수 있는 구조입니다.

#### HandlerInterceptor 인터페이스 메소드

##### 핸들러 실행 전 메소드
```java
boolean preHandle(HttpServletRequest, HttpServletResponse, Handler)
```
- 요청과 응답 객체 그리고 핸들러 정보를 받아서 사용할 수 있습니다
- 리턴값을 `true`로 주면 다음 인터셉터 또는 핸들러에 응답을 전달하고, `false`면 작업을 중단하고 요청 처리를 중지합니다

##### 핸들러 실행 후 메소드
```java
void postHandle(HttpServletRequest, HttpServletResponse, ModelAndView)
```
- 요청과 응답 그리고 모델과 뷰 객체를 받습니다
- 뷰 객체에 공통적으로 사용할 모델 정보를 추가하는데 많이 사용합니다
- 인터셉터가 여러 개일 시 역순으로 호출됩니다
- 비동기 요청은 호출되지 않습니다

##### 뷰 렌더링 후 메소드
```java
void afterCompletion(HttpServletRequest, HttpServletResponse, Handler, Exception)
```
- 인터셉터가 여러 개일 시 역순으로 호출됩니다
- 비동기 요청은 호출되지 않습니다

---

## 11. Resource Handler

**패키지**: `me.kktrkkt.demobootweb.resource_handler`

리소스 핸들러는 정적인 파일들(CSS, HTML, 이미지, 자바스크립트 등)을 처리하는 핸들러입니다.

### 기본 설정
스프링 부트에서는 기본적으로 `resource/static`, `resource/public` 등 정적 리소스 핸들러를 지원합니다.

### 핸들러 추가
`@Configuration` + `WebMvcConfigurer`를 사용하고, `addResourceHandler`를 구현합니다:
```java
registry.addResourceHandler(pattern).addResourceLocation(resource location)
```

### 리소스 캐싱
리소스 핸들러는 추가로 리소스 캐싱 설정이 가능합니다. 리소스 캐싱을 하면 리소스가 업데이트되지 않으면 설정한 시간 동안 캐싱됩니다.

**참고**: [리소스 수정 전략](https://www.slideshare.net/rstoya05/resource-handling-spring-framework-41)

---

## 실행 방법

각 예제는 독립적인 Application 클래스를 가지고 있습니다. 원하는 예제의 Application 클래스를 실행하면 해당 예제를 테스트할 수 있습니다.

```bash
./mvnw spring-boot:run
```

## 기술 스택

- Spring Boot 2.7.15-SNAPSHOT
- Spring MVC
- Java 11
- Maven
- Thymeleaf
- Validation API
