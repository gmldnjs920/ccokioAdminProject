package domain;

public class User {

	private int userNumber;
	private String userId;
	private String userPassWord;
	private String userName;
	private String userTel;
	private String userAddress;
	private String userClass;
	private int coupon;
	private int purchaseQuantity;
	

	public User() {
		
	}


	public int getUserNumber() {
		return userNumber;
	}


	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPassWord() {
		return userPassWord;
	}


	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserTel() {
		return userTel;
	}


	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}


	public String getUserAddress() {
		return userAddress;
	}


	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}


	public String getUserClass() {
		return userClass;
	}


	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}


	public int getCoupon() {
		return coupon;
	}


	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}


	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}


	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	
	
	
}
