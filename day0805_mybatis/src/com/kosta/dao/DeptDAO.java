package com.kosta.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.db.DBManager;
import com.kosta.vo.DeptVO;

@Repository
public class DeptDAO {
	public List<DeptVO> findAll(){
		return DBManager.findAll();
	}
	
	public int insert(DeptVO vo){
		return DBManager.insert(vo);
	}
	
	public DeptVO findByDno(int dno) {
		return DBManager.findByDno(dno);
	}
	
	public int updateDept(DeptVO vo) {
		return DBManager.updateDept(vo);
	}
	
	public int delete(int dno) {
		return DBManager.delete(dno);
	}
}

