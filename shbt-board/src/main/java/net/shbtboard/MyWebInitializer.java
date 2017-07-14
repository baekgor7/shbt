package net.shbtboard;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//내장톰켓을 사용하지 않기위해 만든 클래스
public class MyWebInitializer extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(ShbtBoardApplication.class);
	}
}
