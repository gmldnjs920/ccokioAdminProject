package controller;

import java.util.ArrayList;

import dao.NonUserOrderDao;
import domain.NonUser;
import domain.NonUserOrder;
import view.NonUserOrderListView;

public class NonUserOrderController {

	NonUserOrderDao nonUserOrderDao;

	public NonUserOrderController() {

		nonUserOrderDao = new NonUserOrderDao();

	}

	public void requestNonUserOrderList(NonUser searchNonUser) {

		ArrayList<NonUserOrder> nonUserOrderList = nonUserOrderDao.orderList(searchNonUser);

		NonUserOrderListView nonUserOrderListView = new NonUserOrderListView();
		nonUserOrderListView.nonUserOrderList(nonUserOrderList);

	}

	public void requestNonUserOrderMenuList() {

		NonUserOrderListView nonUserOrderListView = new NonUserOrderListView();
		nonUserOrderListView.nonUserOrderMenuList();

	}

}
