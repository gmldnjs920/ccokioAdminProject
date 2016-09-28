package domain;

public class Login {
	
	private String loginId;
	private String loginPassWord;
	private int loginFlag;
	
	
	public Login(String loginId, String loginPassWord) {
		this.loginId = loginId;
		this.loginPassWord = loginPassWord;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getLoginPassWord() {
		return loginPassWord;
	}


	public void setLoginPassWord(String loginPassWord) {
		this.loginPassWord = loginPassWord;
	}


	public int getLoginFlag() {
		return loginFlag;
	}


	public void setLoginFlag(int loginFlag) {
		this.loginFlag = loginFlag;
	}

}
