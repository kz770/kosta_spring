package day0801_mvcTest02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg","hello ������");
		mav.setViewName("hello");
		return mav;
	}
}
