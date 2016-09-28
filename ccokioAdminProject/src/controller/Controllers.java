package controller;

public class Controllers {

	private static ProgramController programController;
	private static MainController mainController;
	private static LoginController loginController;
	private static ProductController productController;
	private static UserController userController;

	public Controllers() {

		programController = new ProgramController();
		mainController = new MainController();
		loginController = new LoginController();
		productController = new ProductController();
		userController = new UserController();

	}

	public static ProgramController getProgramController() {
		return programController;
		
	}

	public static MainController getMainController() {
		return mainController;
	}

	public static LoginController getLoginController() {
		return loginController;
	}

	public static ProductController getProductController() {
		return productController;
	}

	public static UserController getUserController() {
		return userController;
	}
	
	
	
	

}
