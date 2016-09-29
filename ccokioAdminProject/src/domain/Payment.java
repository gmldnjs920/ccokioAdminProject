package domain;

public class Payment {

	private int userPaymentNumber;
	private String userId;
	private String userName;
	private String productName;
	
	public Payment() {
	
	}

	public int getUserPaymentNumber() {
		return userPaymentNumber;
	}

	public void setUserPaymentNumber(int userPaymentNumber) {
		this.userPaymentNumber = userPaymentNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
}
