package controller;

import java.util.ArrayList;

import dao.PaymentDao;
import domain.Payment;
import view.PaymentListView;

public class UserPaymentController {

	PaymentDao paymentDao;
	
	public UserPaymentController() {
	
		paymentDao = new PaymentDao();
		
	}
	
	public void requestPaymentList() {
		
		ArrayList<Payment> payments = paymentDao.paymentList();
		
		PaymentListView paymentListView = new PaymentListView();
		paymentListView.paymentList(payments);
		
	}
	
}