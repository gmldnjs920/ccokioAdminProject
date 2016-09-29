package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controllers;
import domain.UserOrder;
import domain.User;
import repository.LoginRepository;

public class UserOrderDao {

	public ArrayList<UserOrder> orderList(User searchUser) {
	
		ArrayList<UserOrder> userOrders = new ArrayList<UserOrder>();

		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;

		try{

			String sql = "select o.userOrderNumber, o.userId, o.productName, p.productPrice, o.orderAmount, p.productPrice * o.orderAmount from UserOrder o, product p where o.productName = p.productName and o.paymentflag = 'n' and o.userId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, searchUser.getUserId());
			
			rs = pstmt.executeQuery();

			if(rs.next()){

				UserOrder userOrder = new UserOrder();
				userOrder.setUserOrderNumber(rs.getInt(1));
				userOrder.setUserId(rs.getString(2));
				userOrder.setProductName(rs.getString(3));
				userOrder.setProductPrice(rs.getInt(4));
				userOrder.setOrderAmount(rs.getInt(5));
				userOrder.setTotalPrice(rs.getInt(6));
				userOrders.add(userOrder);

			}

		} catch(SQLException e) {
			e.printStackTrace();
		}finally {

			if(stmt != null){try{stmt.close();} catch (SQLException e){e.printStackTrace();}}
			if(rs != null){try{rs.close();} catch (SQLException e){e.printStackTrace();}}

		}

		return userOrders;
	}
		
}
