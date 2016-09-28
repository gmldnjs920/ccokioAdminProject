package domain;

public class Manager {
	
	private int managerNumber;
	private String managerId;
	private String managerPassWord;
	private String managerName;
	private int managerFlag;
	
	
	public Manager(String managerId, String managerPassWord, String managerName) {
		super();
		this.managerId = managerId;
		this.managerPassWord = managerPassWord;
		this.managerName = managerName;
	}


	public Manager() {

	}


	public int getManagerNumber() {
		return managerNumber;
	}


	public void setManagerNumber(int managerNumber) {
		this.managerNumber = managerNumber;
	}


	public String getManagerId() {
		return managerId;
	}


	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}


	public String getManagerPassWord() {
		return managerPassWord;
	}


	public void setManagerPassWord(String managerPassWord) {
		this.managerPassWord = managerPassWord;
	}


	public String getManagerName() {
		return managerName;
	}


	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	public int getManagerFlag() {
		return managerFlag;
	}


	public void setManagerFlag(int managerFlag) {
		this.managerFlag = managerFlag;
	}
	

	
	

}
