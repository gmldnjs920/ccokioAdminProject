package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controllers;
import domain.Product;

public class ProductDao {
	
	public ArrayList<Product> productSelectList() {

		ArrayList<Product> products = new ArrayList<Product>();

		Statement stmt = null;
		ResultSet rs = null;

		try{
			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select * from system.product";
			rs = stmt.executeQuery(sql);
			while(rs.next()){

				Product product = new Product();
				product.setProductNumber(rs.getInt("productNumber"));
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getInt("productPrice"));
				product.setProductCommant(rs.getString("productCommant"));
				product.setProductOrigin(rs.getString("productOrigin"));
				products.add(product);

			}

		} catch(SQLException e) {
			e.printStackTrace();
		}finally {

			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}

		}

		return products;
	}

	// 존재하는 제품 번호인지 확인하는 Dao
	public boolean checkProductNumber(int selectedProductNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			String sql = "select * from system.product where productNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, selectedProductNumber);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;

	}

	// 상품 등록
	public boolean productRegister(Product newProduct) {

		// 만약 상품이름이 동일하다면 등록되지 않는다.
		// 상품번호는 1씩 증가한다

		boolean success = false;

		Statement stmt = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		int nextProductNumber = 0;

		try {
			
			String sql = "select max(productNumber) + 1 as maxProductNumber from system.product";
			stmt = Controllers.getProgramController().getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			if(rs.next()) {
				nextProductNumber = rs.getInt("maxProductNumber");
				if(rs.wasNull()) { //최초로 제품을 등록할 때
					nextProductNumber = 1;
				}
			}

			newProduct.setProductNumber(nextProductNumber);

			sql = "select * from system.product where productName = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newProduct.getProductName());
			rs = pstmt.executeQuery();
			
			

			if(rs.next()){

				return success;

			} else {


				sql = "insert into system.product values(?,?,?,?,?)";
				pstmt2 = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt2.setInt(1, newProduct.getProductNumber());
				pstmt2.setString(2, newProduct.getProductName());
				pstmt2.setInt(3, newProduct.getProductPrice());
				pstmt2.setString(4, newProduct.getProductCommant());
				pstmt2.setString(5, newProduct.getProductOrigin());
				pstmt2.executeUpdate();
				success = true;

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if(pstmt2 != null){try {pstmt2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs2 != null){try {rs2.close();} catch (SQLException e) {e.printStackTrace();}}
			if(stmt != null){try {stmt.close();} catch (SQLException e) {e.printStackTrace();}}
			if(rs != null){try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt != null){try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}

		}

		return success;
	}

	public Product productSelectOne(int searchProductNumber) {

		Product searchProduct = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from system.product where productNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchProductNumber);
			rs = pstmt.executeQuery();

			if(rs.next()) {

				searchProduct = new Product();
				searchProduct.setProductNumber(rs.getInt("productNumber"));
				searchProduct.setProductName(rs.getString("productName"));
				searchProduct.setProductCommant(rs.getString("productCommant"));
				searchProduct.setProductPrice(rs.getInt("productPrice"));
				searchProduct.setProductOrigin(rs.getString("productOrigin"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
			}
			if(pstmt != null) {
				try { pstmt.close(); } catch (SQLException e) {	e.printStackTrace(); }
			}
		}


		return searchProduct;

	}

	public boolean productUpdate(Product searchProduct, int selectedMenu) {

		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = null;

		try {

			if(selectedMenu == 1) {

				sql = "update system.product set productName = ? where productNumber = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setString(1, searchProduct.getProductName());
				pstmt.setInt(2, searchProduct.getProductNumber());
				result = pstmt.executeUpdate();

			} else if(selectedMenu == 2) {

				sql = "update system.product set productPrice = ? where productNumber = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setInt(1, searchProduct.getProductPrice());
				pstmt.setInt(2, searchProduct.getProductNumber());
				result = pstmt.executeUpdate();
			} else if(selectedMenu == 3) {

				sql = "update system.product set productCommant = ? where productNumber = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setString(1, searchProduct.getProductCommant());
				pstmt.setInt(2, searchProduct.getProductNumber());
				result = pstmt.executeUpdate();
			} else if(selectedMenu == 4) {

				sql = "update system.product set productOrigin = ? where productNumber = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setString(1, searchProduct.getProductOrigin());
				pstmt.setInt(2, searchProduct.getProductNumber());
				result = pstmt.executeUpdate();
			}

			if(result != 0) {
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) { try { pstmt.close();} catch (SQLException e) { e.printStackTrace();}
			}
		}

		return success;
	}
	
	public Product productInfo(int searchProductNumber) {

		Product searchProduct = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from system.Product where productNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchProductNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				searchProduct = new Product();
				searchProduct.setProductNumber(rs.getInt("productNumber"));
				searchProduct.setProductName(rs.getString("productName"));
				searchProduct.setProductPrice(rs.getInt("productPrice"));
				searchProduct.setProductCommant(rs.getString("productCommant"));
				searchProduct.setProductOrigin(rs.getString("productOrigin"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			if(rs != null) { try { rs.close();} catch (SQLException e) { e.printStackTrace();}
			}
			if(pstmt != null) { try { pstmt.close();} catch (SQLException e) { e.printStackTrace();}
			}
		}
		
		return searchProduct;
	}

	public boolean productDelete(int searchProductNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			String sql = "delete from system.Product where productNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchProductNumber);
			result = pstmt.executeUpdate();

			if(result != 0) {
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try { pstmt.close();} catch (SQLException e) { e.printStackTrace();}
			}
		}

		return success;
	}
	

}
