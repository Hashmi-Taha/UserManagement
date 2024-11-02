package servlet_prog;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable {

	private String uname, mid, pwd;

	public UserBean() {
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	

	public String getmid() {
		return mid;
	}

	public void setmid(String mid) {
		this.mid = mid;
	}

	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "UserBean [uname=" + uname + ", mid=" + mid + ", pwd=" + pwd + "]";
	}

	

}
