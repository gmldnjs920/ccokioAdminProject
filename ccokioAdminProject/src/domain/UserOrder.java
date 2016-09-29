package domain;

public class UserOrder {

	private int userOrderNumber;
	private String userId;
	private String productName;
	private int productPrice;
	private int orderAmount;
	private int totalPrice;
	private String paymentFlag;

	public UserOrder() {
	
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

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	

}

