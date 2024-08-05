package exam01;

public class DeptDAO {
	private DeptVO deptVO;

	public void setDeptVO(DeptVO deptVO) {
		this.deptVO = deptVO;
	}
	
	public void insert() {
		System.out.println("부서를 등록하였습니다.");
		System.out.println(deptVO);
	}
}
