package com.kosta.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kosta.vo.DeptVO;

public class DBManager {

	//마이바티스 설정파일에 있는 sql을 사용하기 위한 담당자
	static SqlSessionFactory sqlSessionFactory;
	
	// static {}의 코드는 객체 생성과 무관하게 
	// 시스템이 가동되면 자동으로 동작한다.
	static {
		try {
			
			//마이바티즈 설정파일이 있는 경로
			String resource = "com/kosta/db/dbConfig.xml";
			
			//마이바티즈 설정파일을 갖고 스트림을 생성한다.
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			
			//그 스트림을 가지고 SqlSessionFactory객체를 생성한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			
		}catch(Exception e) {
			System.out.println("DBManager 예외 => "+e.getMessage());
		}
	}
	
	
	// 마이마티스 설정파일에 있는 sql중에 모든 부서목록을 요청하기 위한 메소드
	public static List<DeptVO> findAll(){
		
		//sql을 요청하여 결과를 담을 리스트를 만든다.
		List<DeptVO> list = null;
		
		
		//마이바티스 설정파일에 있는 sql을 요청하기 위한 SqlSession을 얻어온다
		//session : sql을 요청하기 위한 연결망(통로)
		SqlSession session = sqlSessionFactory.openSession();
		
		// 그 세션을 통해서(연결통로) sql을 요청한다. 그 결과를 리스트에 담는다.
		// 우리가 알던 conn,pstmt,resultset해서 setString 해주는 것을 전부해줌.
		list = session.selectList("dept.findAll");		
		
		//세션을 닫아 준다.
		session.close();
		
		//리스트를 반환한다.
		return list;
	}
	
	public static int insert(DeptVO vo) {
		int re=-1;
		
		// 마이바티스 설정 파일에 있는 sql을 요청하기 위해서 sqlsession을 얻어온다.
		SqlSession session = sqlSessionFactory.openSession();

		//sql세션을 통해서 sql을 수행한다.
		re=session.insert("dept.insert",vo);
		
		//commit 명령을 내려야 변경된 내용이 반영된다.
		session.commit();
		session.close();
		return re;
	}
	
	public static DeptVO findByDno(int dno) {
		DeptVO vo=new DeptVO();
		SqlSession session=sqlSessionFactory.openSession();
		vo=session.selectOne("dept.findByDno", dno);
		session.close();
		return vo;
	}
	
	public static int updateDept(DeptVO vo) {
		int re=-1;
		SqlSession session = sqlSessionFactory.openSession();
		re=session.update("dept.updateDept", vo);
		session.commit();
		session.close();
		return re;
	}
	
	public static int delete(int dno) {
		int re=-1;
		SqlSession session=sqlSessionFactory.openSession();
		re=session.delete("dept.delete", dno);
		session.commit();
		session.close();
		return re;
	}
	
}
