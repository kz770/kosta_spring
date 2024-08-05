package com.kosta.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.dao.DeptDAO;
import com.kosta.vo.DeptVO;

import lombok.Setter;

@Controller
@Setter
public class DeptController {
	@Autowired
	private DeptDAO dao;
	
	@RequestMapping("/listDept.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		mav.setViewName("listDept");
		return mav;
	}
	
	@RequestMapping("/insertDept.do")
	public ModelAndView insertForm() {
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("insertDept");
		return mav;
	}
	
	
	@RequestMapping("/insertDeptOK.do")
	public ModelAndView insertSubmit(DeptVO vo) {
		System.out.println(vo);
		int re=dao.insert(vo);
		String msg="부서등록 실패";
		if (re>0) {
			msg="부서등록 성공";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("insertDeptOK");
		return mav;
	}
	
	@RequestMapping("/detailDept.do")
	public void detailDept(int dno, Model model) {
		model.addAttribute("vo",dao.findByDno(dno));
	}
	
	@RequestMapping("/updateDeptOK.do")
	public void updateDept(DeptVO vo, Model m) {
		int re=dao.updateDept(vo);
		String msg="실패";
		if (re>0) {
			msg="성공";
		}
		m.addAttribute("msg",msg);
	}
	
	public ModelAndView delete(int dno) {
		ModelAndView mav=new ModelAndView("redirect:/listDept.do");
		int re=dao.delete(dno);
		if (re<=0) {
			mav.addObject("msg","부서 삭제 실패");
			mav.setViewName("error");
		}
		return mav;
	}
}
