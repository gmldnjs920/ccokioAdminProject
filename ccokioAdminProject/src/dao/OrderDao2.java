package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Controllers;
import domain.NonUser;
import domain.Order2;

public class OrderDao2 {

	public OrderDao2() {

	}

	public boolean orderSelectList(NonUser searchNonUser) {

		boolean success = false;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			String sql = "select n.nonUserOdrerNumber, n.productName, p.productPrice, n.orderAmount "
					+ "from system.NonUserOrder n, system.product p "
					+ "where n.nonUserOrderNumber = ? and p.productName = n.productName";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchNonUser.getNonUserNumber());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Order2 searchOrder = new Order2();
				searchOrder.setOrderNumber(rs.getInt("nonUserOrderNumber"));
				searchOrder.setProductName(rs.getString("productName"));
				searchOrder.setProductPrice(rs.getInt("productPrice"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return success;
	}
}
