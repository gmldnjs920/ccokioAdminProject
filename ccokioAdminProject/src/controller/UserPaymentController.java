package controller;

import java.util.ArrayList;

import dao.UserPaymentDao;
import domain.User;
import domain.UserPayment;
import view.UserPaymentListView;

public class UserPaymentController {

	UserPaymentDao userPaymentDao;
	
	public UserPaymentController() {
	
		userPaymentDao = new UserPaymentDao();
		
	}
	
	public void requestPaymentList(User searchUser) {
		
		ArrayList<UserPayment> userPaymentList = userPaymentDao.userPaymentList(searchUser);
		
		UserPaymentListView userPaymentListView = new UserPaymentListView();
		userPaymentListView.userPaymentList(userPaymentList);
		
	}

	public void requestPaymentMenuList() {
		
		UserPaymentListView userPaymentListView = new UserPaymentListView();
		userPaymentListView.userPaymentMenuList();
		
	}
	
}