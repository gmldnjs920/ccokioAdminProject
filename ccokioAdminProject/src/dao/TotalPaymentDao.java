package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controllers;
import domain.TotalPayment;

public class TotalPaymentDao {

	public ArrayList<TotalPayment> totalPaymentSelectList() {

		Statement stmt = null, stmt2 = null;;
		ResultSet rs = null, rs2 = null;;
		ArrayList<TotalPayment> totalPaymentList = new ArrayList<TotalPayment>();

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select o.userId, u.userName, u.userTel, o.productName, p.productPrice, o.orderAmount, p.productPrice * o.orderAmount from UserOrder o, User1 u, Product p where o.userId = u.userId and o.productName = p.productName and o.paymentflag = 'y'";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				TotalPayment userPayment = new TotalPayment();
				userPayment.setUserId(rs.getString(1));
				userPayment.setUserName(rs.getString(2));
				userPayment.setUserTel(rs.getString(3));
				userPayment.setProductName(rs.getString(4));
				userPayment.setProductPrice(rs.getInt(5));
				userPayment.setOrderAmount(rs.getInt(6));
				userPayment.setTotalPrice(rs.getInt(7));
				totalPaymentList.add(userPayment);

			}
			
			stmt2 = Controllers.getProgramController().getConnection().createStatement();
			sql = "select u.nonuserName, o.nonuserTel, o.productName, p.productPrice, o.orderAmount, p.productPrice * o.orderAmount from NonUserOrder o, NonUser u, Product p where o.nonuserTel = u.nonuserTel and o.productName = p.productName and o.paymentflag = 'y'";
			rs2 = stmt2.executeQuery(sql);

			while(rs2.next()) {
				TotalPayment userPayment = new TotalPayment();
				userPayment.setUserName(rs2.getString(1));
				userPayment.setUserTel(rs2.getString(2));
				userPayment.setProductName(rs2.getString(3));
				userPayment.setProductPrice(rs2.getInt(4));
				userPayment.setOrderAmount(rs2.getInt(5));
				userPayment.setTotalPrice(rs2.getInt(6));
				totalPaymentList.add(userPayment);

			}
			


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs2 != null) {
				try {
					rs2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(stmt2 != null) {
				try {
					stmt2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return totalPaymentList;
	}
	
}
