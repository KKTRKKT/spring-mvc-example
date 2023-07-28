package me.kktrkkt.demobootweb.intercepter;

/*
Intercepter는 핸들러 매핑에 정할 수 있는설 객체로, 핸들러 실행 전, 후 그리고 렌더링 후 처리를 할 수 있다.

인터셉터는 HandlerInterceptor를 구현해서 만들고, WebMvc 설정에서 addInterceptor 메소드를 통해 등록할 수 있다.

핸들러 실행 전 메소드
boolean preHandle(HttpServletRequest, HttpServletResponse, Hanlder)
- 요청과 응답 객체 그리고 핸들러 정보를 받아서 사용할 수 있다.
- 리턴값을 true로 주면 다음 인터셉터 또는 핸들러에 응답을 전달하고, false면 작업을 중단하고 요청 처리를 중지한다

핸들러 실행 후 메소드
void postHandle(HttpServletRequest, HttpServletResponse, ModelAndView)
- 요청과 응답 그리고 모델과 뷰 객체를 받는다.
- 뷰 객체에 공통적으로 사용할 모델 정보를 추가하는데 많이 사용한다
- 인터셉터가 여러개일시 역순으로 호출
- 비동기 요청은 호출되지 않음

뷰 렌더링 후 메소드
void afterCompletion(HttpServletRequest, HttpServletResponse, Handler, Exception)
- 인터셉터가 여러개일시 역순으로 호출
- 비동기 요청은 호출되지 않음

 */