package com.kosta.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kosta.vo.DeptVO;

public class DBManager {

	//���̹�Ƽ�� �������Ͽ� �ִ� sql�� ����ϱ� ���� �����
	static SqlSessionFactory sqlSessionFactory;
	
	// static {}�� �ڵ�� ��ü ������ �����ϰ� 
	// �ý����� �����Ǹ� �ڵ����� �����Ѵ�.
	static {
		try {
			
			//���̹�Ƽ�� ���������� �ִ� ���
			String resource = "com/kosta/db/dbConfig.xml";
			
			//���̹�Ƽ�� ���������� ���� ��Ʈ���� �����Ѵ�.
			InputStream inputStream = Resources.getResourceAsStream(resource);
			
			
			//�� ��Ʈ���� ������ SqlSessionFactory��ü�� �����Ѵ�.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			
		}catch(Exception e) {
			System.out.println("DBManager ���� => "+e.getMessage());
		}
	}
	
	
	// ���̸�Ƽ�� �������Ͽ� �ִ� sql�߿� ��� �μ������ ��û�ϱ� ���� �޼ҵ�
	public static List<DeptVO> findAll(){
		
		//sql�� ��û�Ͽ� ����� ���� ����Ʈ�� �����.
		List<DeptVO> list = null;
		
		
		//���̹�Ƽ�� �������Ͽ� �ִ� sql�� ��û�ϱ� ���� SqlSession�� ���´�
		//session : sql�� ��û�ϱ� ���� �����(���)
		SqlSession session = sqlSessionFactory.openSession();
		
		// �� ������ ���ؼ�(�������) sql�� ��û�Ѵ�. �� ����� ����Ʈ�� ��´�.
		// �츮�� �˴� conn,pstmt,resultset�ؼ� setString ���ִ� ���� ��������.
		list = session.selectList("dept.findAll");		
		
		//������ �ݾ� �ش�.
		session.close();
		
		//����Ʈ�� ��ȯ�Ѵ�.
		return list;
	}
	
	public static int insert(DeptVO vo) {
		int re=-1;
		
		// ���̹�Ƽ�� ���� ���Ͽ� �ִ� sql�� ��û�ϱ� ���ؼ� sqlsession�� ���´�.
		SqlSession session = sqlSessionFactory.openSession();

		//sql������ ���ؼ� sql�� �����Ѵ�.
		re=session.insert("dept.insert",vo);
		
		//commit ����� ������ ����� ������ �ݿ��ȴ�.
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
