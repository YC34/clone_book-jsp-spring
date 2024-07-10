package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringStudyApplication.class);
	}

}

/**
 * 자동으로 생기는 이 클래스는 web.xml을 읽기 위한 클래스 인가?
 *
 *  스프링 부트 웹 애플리케이션을 배포할 때 jar를 이용하기도 하지만,
 *  전통적인 방식인 war 파일로 배포하는 경우가 있다.
 * 이때 SpringBootServletInitializer를 상속받아 배포하게 된다.
 */
