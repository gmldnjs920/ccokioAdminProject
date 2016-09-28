package controller;

import java.util.ArrayList;

import dao.ManagerDao;
import domain.Manager;
import view.AlertView;
import view.ManagerDeleteView;
import view.ManagerRegisterView;
import view.ManagerSelectListView;
import view.ManagerSelectOneView;
import view.ManagerUpdateView;
import view.UserDeleteView;



public class ManagerController {

	ManagerDao managerDao;

	public ManagerController() {

		managerDao = new ManagerDao(); 

	}

	public void requestSelectList() {

		ArrayList<Manager> managerList = managerDao.managerSelectList();

		ManagerSelectListView managerSelectListView = new ManagerSelectListView();
		managerSelectListView.managerSelctList(managerList);

	}

	public void requestSelectMenuList() {

		ManagerSelectListView managerSelectListView = new ManagerSelectListView();
		managerSelectListView.managerSelectMenuList();

	}

	public void requestRegister() {

		ManagerRegisterView managerRegisterView = new ManagerRegisterView();
		managerRegisterView.managerRegister();

	}

	public void requestReturnRegister(Manager newManager) {

		boolean success = managerDao.managerRegister(newManager);

		if(success) {
			new AlertView().alert("매니저 등록을 성공했습니다.");
		} else {
			new AlertView().alert("중복된 아이디가 있습니다.");
		}

		Controllers.getManagerController().requestSelectList();

	}

	public void requestSelectOne() {

		ManagerSelectOneView managerSelectOneView = new ManagerSelectOneView();
		managerSelectOneView.getSearchManagerNumber();

	}

	public void requestReturnSelectOne(int searchManagerNumber) {

		boolean success = managerDao.checkManagerNumber(searchManagerNumber);

		if(success) {

			Manager searchManager = managerDao.managerSelectOne(searchManagerNumber);
			ManagerSelectOneView managerSelectOneView = new ManagerSelectOneView();
			managerSelectOneView.managerSelectOne(searchManager);

		} else {
			new AlertView().alert("존재하지 않는 매니저입니다.");
			Controllers.getManagerController().requestSelectList();
		}

	}

	public void requestSelectOneMenu(Manager searchManager) {

		ManagerSelectOneView managerSelectOneView = new ManagerSelectOneView();
		managerSelectOneView.managerSelectOneMenu(searchManager);


	}


	public void requestUpdateSearchNumber() {

		ManagerUpdateView managerUpdateView = new ManagerUpdateView();
		managerUpdateView.getSearchManagerNumber();

	}


	public void requestUpdate(int searchManagerNumber) {

		boolean success = managerDao.checkManagerNumber(searchManagerNumber);

		if(success) {
			Manager searchManager = managerDao.managerInfo(searchManagerNumber);	
			ManagerUpdateView managerUpdateView = new ManagerUpdateView();
			managerUpdateView.managerUpdate(searchManager);
		} else {
			new AlertView().alert("존재하지 않는 회원입니다.");
			Controllers.getManagerController().requestSelectList();
		}

	}
	
	public void requestReturnUpdate(Manager searchManager, int selectedMenu) {
		
		boolean success = managerDao.managerUpdate(searchManager, selectedMenu);

		if(success) {
			new AlertView().alert("매니저정보 수정을 성공했습니다.");
		} else {
			new AlertView().alert("매니저정보 수정을 실패했습니다.");
		}
		Controllers.getManagerController().requestUpdate(searchManager.getManagerNumber());
		
	}


	public void requestDeleteSearchNumber() {

		ManagerDeleteView managerDeleteView = new ManagerDeleteView();
		managerDeleteView.getSearchManagerNumber();

	}



	public void requestDelete(int searchManagerNumber) {

		boolean success = managerDao.checkManagerNumber(searchManagerNumber);

		if(success) {
			ManagerDeleteView managerDeleteView = new ManagerDeleteView();
			managerDeleteView.managerDelete(searchManagerNumber);
		} else {
			new AlertView().alert("존재하지 않는 매니저입니다.");
			Controllers.getManagerController().requestSelectList();
		}

	}

	public void requestReturnDelete(int searchManagerNumer) {

		boolean success = managerDao.managerDelete(searchManagerNumer);

		if(success) {
			new AlertView().alert("매니저를 탈퇴시켰습니다.");
		} else {
			new AlertView().alert("매니저탈퇴를 실패했습니다.");
		}
		Controllers.getManagerController().requestSelectList();

	}



}
