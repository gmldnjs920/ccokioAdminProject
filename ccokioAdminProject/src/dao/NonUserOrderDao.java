package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controllers;
import domain.NonUser;
import domain.NonUserOrder;

public class NonUserOrderDao {

	public ArrayList<NonUserOrder> orderList(NonUser searchNonUser) {

		ArrayList<NonUserOrder> nonUserOrders = new ArrayList<NonUserOrder>();

		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "select o.nonUserOrderNumber, o.nonUserTel, o.productName, p.productPrice, o.orderAmount, p.productPrice * o.orderAmount from NonUserOrder o, product p where o.productName = p.productName and o.paymentflag = 'n' and o.nonUserTel = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchNonUser.getNonUserTel());

			rs = pstmt.executeQuery();

			if (rs.next()) {

				NonUserOrder nonUserOrder = new NonUserOrder();
				nonUserOrder.setNonUserOrderNumber(rs.getInt(1));
				nonUserOrder.setNonUserTel(rs.getString(2));
				nonUserOrder.setProductName(rs.getString(3));
				nonUserOrder.setProductPrice(rs.getInt(4));
				nonUserOrder.setOrderAmount(rs.getInt(5));
				nonUserOrder.setTotalPrice(rs.getInt(6));
				nonUserOrders.add(nonUserOrder);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return nonUserOrders;
	}

}
