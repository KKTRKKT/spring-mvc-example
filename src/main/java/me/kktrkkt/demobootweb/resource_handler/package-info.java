package me.kktrkkt.demobootweb.resource_handler;

/*
리소스 핸들러는 정적인 파일들(CSS, HTML, 이미지, 자바스크립트 등)을 처리하는 핸들러

스프링 부트에서는 기본적으로 resource/static, resource/public 등 정적 리소스 핸들러를 지원한다

핸들러를 추가하려면, @Configuration + WebMvcConfigure를 사용하고, addResourceHandler를 구현한다.
registry.addResourceHandler(pattern).addResourceLocation(resource location)
 */