package com.kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav=new ModelAndView();		// ����� ��û�� ���� ó���� ������
		mav.addObject("msg","hello Spring");		// ������ ��������
		mav.setViewName("/WEB-INF/views/hello.jsp");// �����ϴ� �� �˷��ֱ�
		return mav;
	}

}
