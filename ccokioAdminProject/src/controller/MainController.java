package controller;

import view.MainView;

public class MainController {


	public void requestMainList() {

		MainView mainView = new MainView();
		mainView.mainView();

	} 
	
	public void requestAdminMainList() {

		MainView mainView = new MainView();
		mainView.adminMainView();

	}
	
	public void requestManagerMainList() {

		MainView mainView = new MainView();
		mainView.managerMainView();

	}
	

}

