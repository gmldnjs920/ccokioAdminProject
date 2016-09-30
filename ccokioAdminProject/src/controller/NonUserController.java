package controller;

import java.util.ArrayList;

import dao.NonUserDao;
import domain.NonUser;
import domain.User;
import view.AlertView;
import view.NonUserSelectListView;
import view.NonUserSelectOneView;
import view.UserSelectOneView;

public class NonUserController {

	private NonUserDao nonUserDao;

	public NonUserController() {

		nonUserDao = new NonUserDao();

	}

	public void requestSelectList() {

		ArrayList<NonUser> nonUserList = nonUserDao.nonUserSelectList();

		NonUserSelectListView nonUserSelectListView = new NonUserSelectListView();
		nonUserSelectListView.nonUserSelctList(nonUserList);

	}

	public void requestNonUserSelectMenuList() {

		NonUserSelectListView nonUserSelectListView = new NonUserSelectListView();
		nonUserSelectListView.nonUserSelectMenuList();

	}

	public void requestSelectOne() {

		NonUserSelectOneView nonUserSelectOneView = new NonUserSelectOneView();
		nonUserSelectOneView.getSearchNonUserNumber();

	}

	public void requestReturnNonUserSelectOne(int searchNonUserNumber) {

		boolean success = nonUserDao.checkNonUserNumber(searchNonUserNumber);

		if (success) {

			NonUser searchNonUser = nonUserDao.nonUserSelectOne(searchNonUserNumber);
			NonUserSelectOneView nonUserSelectOneView = new NonUserSelectOneView();
			nonUserSelectOneView.nonUserSelectOne(searchNonUser);

		} else {
			new AlertView().alert("존재하지 않는 비회원입니다.");
			Controllers.getNonUserController().requestSelectList();
		}

	}
	
	public void requestSelectOneMenu(NonUser searchNonUser) {

		NonUserSelectOneView nonUserSelectOneView = new NonUserSelectOneView();
		nonUserSelectOneView.nonUserSelectOneMenu(searchNonUser);


	}

}
