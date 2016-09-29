package controller;

import java.util.ArrayList;

import dao.ProductDao;
import domain.Product;
import view.AlertView;
import view.ManagerUpdateView;
import view.ProductDeleteView;
import view.ProductRegisterView;
import view.ProductSelectListView;
import view.ProductSelectOneView;
import view.ProductUpdateView;

public class ProductController {

	private ProductDao productDao;

	public ProductController() {

		this.productDao = new ProductDao();

	}

	//제품 목록  dao
	public void requestProductSelectList() {

		ArrayList<Product> products = productDao.productSelectList();

		ProductSelectListView productSelectListView = new ProductSelectListView();
		productSelectListView.productList(products);
	}

	//제품 목록 메뉴 view
	public void requestSelectMenuList() {

		ProductSelectListView productSelectListView = new ProductSelectListView();
		productSelectListView.productSelectMenuList();

	}

	//제품 조회 view
	public void requestProductSelectOne() {

		ProductSelectOneView productSelectOneView = new ProductSelectOneView();
		productSelectOneView.getSearchProductNumber();

	}

	//제품 조회 dao
	public void requestReturnSelectOne(int searchProductNumber) {

		boolean success = productDao.checkProductNumber(searchProductNumber);

		if(success) {

			Product searchProduct = productDao.productSelectOne(searchProductNumber);
			ProductSelectOneView productSelectOneView = new ProductSelectOneView();
			productSelectOneView.productSelectOne(searchProduct);

		} else {
			new AlertView().alert("존재하지 않는 제품입니다.");
			Controllers.getProductController().requestProductSelectList();
		}

	}

	//제품 조회 메뉴 view
	public void requestSelectOneMenu(Product searchProduct) {

		ProductSelectOneView productSelectOneView = new ProductSelectOneView();
		productSelectOneView.ProductSelectOneMenu(searchProduct);
		
	}

	//제품 등록 view
	public void requestProductRegister() {

		ProductRegisterView productRegisterView = new ProductRegisterView();
		productRegisterView.productRegisterView();

	}

//제품 등록 dao
	public void requestReturnProductRegister(Product newProduct) {

		boolean success = productDao.productRegister(newProduct);

		if (success) {
			AlertView alertView = new AlertView();
			alertView.alert("제품등록 성공");
		} else {
			AlertView alertView = new AlertView();
			alertView.alert("제품등록 실패");
		}
		Controllers.getProductController().requestProductSelectList();
	}
//제품 수정 
	public void requestUpdateSearchNumber() {

		ProductUpdateView productUpdateView = new ProductUpdateView();
		productUpdateView.getSearchProductNumber();

	}


	public void requestUpdate(int searchProductNumber) {

		boolean success = productDao.checkProductNumber(searchProductNumber);

		if(success) {
			Product searchProduct = productDao.productInfo(searchProductNumber);
			ProductUpdateView productUpdateView = new ProductUpdateView();
			productUpdateView.productUpdate(searchProduct);
		} else {
			new AlertView().alert("존재하지 않는 제품입니다.");
			Controllers.getProductController().requestSelectMenuList();
		}

	}
	
	public void requestReturnUpdate(Product searchProduct, int selectedMenu) {
		
		boolean success = productDao.productUpdate(searchProduct, selectedMenu);

		if(success) {
			new AlertView().alert("제품정보 수정을 성공했습니다.");
		} else {
			new AlertView().alert("제품정보 수정을 실패했습니다.");
		}
			Controllers.getProductController().requestUpdate(searchProduct.getProductNumber());
	}


	public void requestDeleteSearchNumber() {

		ProductDeleteView productDeleteView = new ProductDeleteView();
		productDeleteView.getSearchProductNumber();

	}



	public void requestDelete(int searchProductNumber) {

		boolean success = productDao.checkProductNumber(searchProductNumber);
		if(success) {
			ProductDeleteView productDeleteView = new ProductDeleteView();
			productDeleteView.productDelete(searchProductNumber);
		} else {
			new AlertView().alert("존재하지 않는 제품입니다.");
			Controllers.getProductController().requestSelectMenuList();
		}

	}

	public void requestReturnDelete(int searchProductNumber) {

		boolean success = productDao.productDelete(searchProductNumber);

		if(success) {
			new AlertView().alert("제품을 삭제시켰습니다.");
		} else {
			new AlertView().alert("제품삭제를 실패했습니다.");
		}
		Controllers.getProductController().requestProductSelectList();
	}

}
