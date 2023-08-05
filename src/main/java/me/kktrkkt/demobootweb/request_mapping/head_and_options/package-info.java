package me.kktrkkt.demobootweb.request_mapping.head_and_options;

/*
head와 options는 http method의 일종으로 head로 요청을 보내면 본문 없이 결과를 리턴해주고, options로 요청을 보내면 본문없이 allow(사용 가능한 메소드)만 가져온다

spring에서는 핸들러를 구현하면 자동으로 추가해주기 때문에 따로 head와 options 핸들러를 만들지 않아도 된다.

 */