package day0801_mvcTest02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
	POJO(Plain Old Java Object)
	==> 옛날방식의 스프링에서는 컨트롤러가 되려면 스프링이 제공하는 Controller 인터페이스를 구현해야 하고 
	그 인터페이스의 추상메소드인 handelRequest를 오버라이딩 해야만 컨트롤러를 만들 수 있었어요.
	이러한 방식을 "프레임워크 의존적"이라곡 말합니다.
	
	현재의 스프링에서는 "프레임워크 의존적"이지 않고 
	어떤 인터페이스를 구현할 필요도 없이 메소드 이름도 자유롭게 하여 원래 자바 클래스 만들듯이 
	작성하여 컨트롤러를 만들 수 있어요. 이러한 방식을 POJO 방식이라고 합니다.
 */
		
		

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "hello 스프링!!!");
		mav.setViewName("hello");
		return mav;
	}
}
