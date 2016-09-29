package controller;

import java.util.ArrayList;

import dao.UserDao;
import domain.User;
import view.AlertView;
import view.UserDeleteView;
import view.UserSelectListView;
import view.UserSelectOneView;



public class UserController {

	UserDao userDao;

	public UserController() {

		userDao = new UserDao(); 

	}

	public void requestSelectList() {

		ArrayList<User> userList = userDao.userSelectList();

		UserSelectListView userSelectListView = new UserSelectListView();
		userSelectListView.userSelctList(userList);

	}

	public void requestSelectMenuList() {

		UserSelectListView userSelectListView = new UserSelectListView();
		userSelectListView.userSelectMenuList();

	}

	public void requestSelectOne() {

		UserSelectOneView userSelectOneView = new UserSelectOneView();
		userSelectOneView.getSearchUserNumber();

	}

	public void requestReturnSelectOne(int searchUserNumber) {

		boolean success = userDao.checkUserNumber(searchUserNumber);

		if(success) {

			User searchUser = userDao.userSelectOne(searchUserNumber);
			UserSelectOneView productSelectOneView = new UserSelectOneView();
			productSelectOneView.userSelectOne(searchUser);

		} else {
			new AlertView().alert("존재하지 않는 회원입니다.");
			Controllers.getUserController().requestSelectList();
		}

	}

	public void requestSelectOneMenu(User searchUser) {

		UserSelectOneView userSelectOneView = new UserSelectOneView();
		userSelectOneView.userSelectOneMenu(searchUser);

	}

	public void requestDeleteSearchNumber() {

		UserDeleteView userDeleteView = new UserDeleteView();
		userDeleteView.getSearchUserNumber();

	}

	public void requestDelete(int searchUserNumber) {

		boolean success = userDao.checkUserNumber(searchUserNumber);

		if(success) {
			UserDeleteView userDeleteView = new UserDeleteView();
			userDeleteView.userDelete(searchUserNumber);
		} else {
			new AlertView().alert("존재하지 않는 회원입니다.");
			Controllers.getUserController().requestSelectList();
		}

	}

	public void requestReturnDelete(int searchUserNumer) {

		boolean success = userDao.userDelete(searchUserNumer);

		if(success) {
			new AlertView().alert("회원을 탈퇴시켰습니다.");
		} else {
			new AlertView().alert("회원탈퇴를 실패했습니다.");
		}
		Controllers.getUserController().requestSelectList();

	}




}
