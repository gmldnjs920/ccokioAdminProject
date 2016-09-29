package domain;

public class Order {

	private int userOrderNumber;
	private String userId;
	private String userName;
	private String productName;
	private int orderAmount;
	private String paymentFlag;

	public Order() {
	
	}
	
	public Order(String productName, int orderAmount) {
		
		this.productName = productName;
		this.orderAmount = orderAmount;
	}

	public int getUserOrderNumber() {
		return userOrderNumber;
	}

	public void setUserOrderNumber(int userOrderNumber) {
		this.userOrderNumber = userOrderNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getPaymentFlag() {
		return paymentFlag;
	}

	public void setPaymentFlag(String paymentFlag) {
		this.paymentFlag = paymentFlag;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

