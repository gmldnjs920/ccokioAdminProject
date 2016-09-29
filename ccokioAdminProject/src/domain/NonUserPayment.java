package domain;

public class NonUserPayment {

	private int nonUserPaymentNumber;
	private int nonUserOrderNumber;
	private String nonUserTel;
	private String productName;
	private int productPrice;
	private int orderAmount;
	private int totalPrice;
	private String paymentFlag;

	public NonUserPayment() {

	}

	public int getNonUserPaymentNumber() {
		return nonUserPaymentNumber;
	}

	public void setNonUserPaymentNumber(int nonUserPaymentNumber) {
		this.nonUserPaymentNumber = nonUserPaymentNumber;
	}

	public int getNonUserOrderNumber() {
		return nonUserOrderNumber;
	}

	public void setNonUserOrderNumber(int nonUserOrderNumber) {
		this.nonUserOrderNumber = nonUserOrderNumber;
	}

	public String getNonUserTel() {
		return nonUserTel;
	}

	public void setNonUserTel(String nonUserTel) {
		this.nonUserTel = nonUserTel;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentFlag() {
		return paymentFlag;
	}

	public void setPaymentFlag(String paymentFlag) {
		this.paymentFlag = paymentFlag;
	}

}
