package exam01;

public class DeptVO {
	private int dno;
	private String dname;
	private String dloc;
	public void setDno(int dno) {
		this.dno = dno;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setDloc(String dloc) {
		this.dloc = dloc;
	}
	@Override
	public String toString() {
		return "DeptVO [dno=" + dno + ", dname=" + dname + ", dloc=" + dloc + "]";
	}
	
}
