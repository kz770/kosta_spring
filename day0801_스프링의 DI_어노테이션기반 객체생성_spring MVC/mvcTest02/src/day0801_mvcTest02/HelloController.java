package day0801_mvcTest02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
	POJO(Plain Old Java Object)
	==> ��������� ������������ ��Ʈ�ѷ��� �Ƿ��� �������� �����ϴ� Controller �������̽��� �����ؾ� �ϰ� 
	�� �������̽��� �߻�޼ҵ��� handelRequest�� �������̵� �ؾ߸� ��Ʈ�ѷ��� ���� �� �־����.
	�̷��� ����� "�����ӿ�ũ ������"�̶�� ���մϴ�.
	
	������ ������������ "�����ӿ�ũ ������"���� �ʰ� 
	� �������̽��� ������ �ʿ䵵 ���� �޼ҵ� �̸��� �����Ӱ� �Ͽ� ���� �ڹ� Ŭ���� ������� 
	�ۼ��Ͽ� ��Ʈ�ѷ��� ���� �� �־��. �̷��� ����� POJO ����̶�� �մϴ�.
 */
		
		

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "hello ������!!!");
		mav.setViewName("hello");
		return mav;
	}
}
