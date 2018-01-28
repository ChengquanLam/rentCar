package bean;
/**
 * @author liuleilei liuleilei2015@gmail.com
 * @date 2018年1月14日 下午8:49:39
 * @Description: TODO
 */
public class UsersBean {
	private String Username;
	private String Password;
	private String Usex;
	private String Uname;
	private String Urole;
	private String UID;
	
	public UsersBean(String username, String password, String usex, String uname, String urole, String uID) {
		super();
		Username = username;
		Password = password;
		Usex = usex;
		Uname = uname;
		Urole = urole;
		UID = uID;
	}
	public UsersBean() {}
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUsex() {
		return Usex;
	}
	public void setUsex(String usex) {
		Usex = usex;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUrole() {
		return Urole;
	}
	public void setUrole(String urole) {
		Urole = urole;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
}
