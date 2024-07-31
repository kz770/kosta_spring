package diTest11;

public class DataSource {
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void info() {
		System.out.println("driver:"+driver);
		System.out.println("url:"+url);
		System.out.println("username:"+username);
		System.out.println("password:"+password);
	}
}
