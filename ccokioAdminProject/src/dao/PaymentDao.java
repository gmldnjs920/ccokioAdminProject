package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controllers;
import domain.Payment;
import repository.LoginRepository;

public class PaymentDao {

	public ArrayList<Payment> paymentList() {

		ArrayList<Payment> payments = new ArrayList<Payment>();

		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try{

			String sql = "select * from UserPayment where userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());

			rs = pstmt.executeQuery();

			while(rs.next()){

				Payment payment = new Payment();
				payment.setUserPaymentNumber(rs.getInt("userPaymentNumber"));
				payment.setUserId(rs.getString("userId"));
				payment.setUserName(rs.getString("userName"));
				payment.setProductName(rs.getString("productName"));
				payments.add(payment);

			}

		} catch(SQLException e) {
			e.printStackTrace();
		}finally {

			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}

		}

		return payments;
	}

}
