package com.kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav=new ModelAndView();		// 사용자 요청에 의해 처리된 데이터
		mav.addObject("msg","hello Spring");		// 데이터 상태유지
		mav.setViewName("/WEB-INF/views/hello.jsp");// 가야하는 곳 알려주기
		return mav;
	}

}
