package controller;

import java.util.ArrayList;

import dao.UserOrderDao;
import domain.UserOrder;
import domain.User;
import view.UserOrderListView;

public class UserOrderController {

	UserOrderDao userOrderDao;
	
	public UserOrderController() {
	
		userOrderDao = new UserOrderDao();
		
	}
	
	public void requestUserOrderList(User searchUser) {
		
		ArrayList<UserOrder> userOrderList = userOrderDao.orderList(searchUser);
		
		UserOrderListView userOrderListView = new UserOrderListView();
		userOrderListView.userOrderList(userOrderList);
		
	}

	public void requestUserOrderMenuList() {
		
		UserOrderListView userOrderListView = new UserOrderListView();
		userOrderListView.userOrderMenuList();
		
	}
	
}
