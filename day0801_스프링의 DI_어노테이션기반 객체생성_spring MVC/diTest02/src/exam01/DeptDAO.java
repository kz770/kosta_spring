package exam01;

public class DeptDAO {
	private DeptVO deptVO;

	public void setDeptVO(DeptVO deptVO) {
		this.deptVO = deptVO;
	}
	
	public void insert() {
		System.out.println("�μ��� ����Ͽ����ϴ�.");
		System.out.println(deptVO);
	}
}
