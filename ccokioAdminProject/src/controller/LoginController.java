package controller;

import dao.LoginDao;
import domain.Login;
import view.AlertView;
import view.LoginView;

public class LoginController {

	LoginDao loginDao;

	public LoginController() {
		loginDao = new LoginDao();
	}


	public void requestLogin() {

		LoginView loginView = new LoginView();
		loginView.login();
	}

	public void requestReturnLogin(Login login) {

		boolean success = loginDao.login(login);

		if(success) {
			new AlertView().alert("로그인 성공 했습니다.");
			int LoginFlag = loginDao.checkLogin();
			if(LoginFlag == 0) {
				Controllers.getProgramController().requestConnectionAdmin();
				Controllers.getMainController().requestAdminMainList();
			} else if(LoginFlag == 1) {
				Controllers.getProgramController().requestConnectionManager();
				Controllers.getMainController().requestManagerMainList();
			}
		} else {
			new AlertView().alert("아이디 혹은 비밀번호가 틀립니다.");
			Controllers.getMainController().requestMainList();
		}

	}

	public void requestLogout() {

		boolean success = loginDao.logout();

		if(success) {
			new AlertView().alert("로그아웃 성공 했습니다.");
		} else {
			new AlertView().alert("로그아웃 실패 했습니다.");
		}

		Controllers.getMainController().requestMainList();

	}
	
	public void requestCheckLogin() {

		int loginFlag = loginDao.checkLogin();
		
		if(loginFlag == 0) {
			Controllers.getMainController().requestAdminMainList();
		} else {
			Controllers.getMainController().requestManagerMainList();
		}
	}

}
