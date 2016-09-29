package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controllers;
import domain.NonUser;
import domain.NonUserPayment;

public class NonUserPaymentDao {

	public ArrayList<NonUserPayment> nonUserPaymentList(NonUser searchNonUser) {

		ArrayList<NonUserPayment> nonUserPaymentList = new ArrayList<NonUserPayment>();

		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "select pm.nonUserPaymentNumber, pm.nonUserOrderNumber, o.nonUserTel, o.productName, p.productPrice, o.orderAmount, p.productPrice * o.orderAmount "
					+ "from nonUserOrder o, product p, nonUserPayment pm "
					+ "where pm.nonUserOrderNumber = o.nonUserOrderNumber "
					+ "and o.productName = p.productName "
					+ "and o.paymentflag = 'y' and o.nonUserTel = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchNonUser.getNonUserTel());

			rs = pstmt.executeQuery();

			if (rs.next()) {

				NonUserPayment nonUserPayment = new NonUserPayment();
				nonUserPayment.setNonUserPaymentNumber(rs.getInt(1));
				nonUserPayment.setNonUserOrderNumber(rs.getInt(2));
				nonUserPayment.setNonUserTel(rs.getString(3));
				nonUserPayment.setProductName(rs.getString(4));
				nonUserPayment.setProductPrice(rs.getInt(5));
				nonUserPayment.setOrderAmount(rs.getInt(6));
				nonUserPayment.setTotalPrice(rs.getInt(7));
				nonUserPaymentList.add(nonUserPayment);

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

		return nonUserPaymentList;
	}

}
