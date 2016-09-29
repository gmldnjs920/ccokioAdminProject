package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controllers;
import domain.Order;
import repository.LoginRepository;

public class OrderDao {

	public ArrayList<Order> orderList() {
	
		ArrayList<Order> orders = new ArrayList<Order>();

		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try{

			String sql = "select * from UserOrder where userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, LoginRepository.getLogin().getLoginId());
			
			rs = pstmt.executeQuery();

			while(rs.next()){

				Order order = new Order();
				order.setUserOrderNumber(rs.getInt("userOrderNumber"));
				order.setUserId(rs.getString("userId"));
				order.setProductName(rs.getString("productName"));
				order.setOrderAmount(rs.getInt("orderAmount"));
				order.setPaymentFlag(rs.getString("paymentflag"));
				orders.add(order);

			}

		} catch(SQLException e) {
			e.printStackTrace();
		}finally {

			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}

		}

		return orders;
	}
		
}
