package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controllers;
import domain.User;

public class UserDao {

	public ArrayList<User> userSelectList() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<User> userList = new ArrayList<User>();

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select * from system.user1";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {

				User user = new User();
				user.setUserNumber(rs.getInt("userNumber"));
				user.setUserId(rs.getString("userId"));
				user.setUserPassWord(rs.getString("userPassWord"));
				user.setUserName(rs.getString("userName"));
				user.setUserTel(rs.getString("userTel"));
				user.setUserAddress(rs.getString("userAddress"));
				user.setUserClass(rs.getString("userClass"));
				user.setCoupon(rs.getInt("coupon"));
				user.setPurchaseQuantity(rs.getInt("purchaseQuantity"));
				userList.add(user);

			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

		return userList;
	}

	public boolean checkUserNumber(int searchUserNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from system.user1 where userNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchUserNumber);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;

	}

	public User userSelectOne(int searchUserNumber) {

		User searchUser = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from system.user1 where userNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchUserNumber);
			rs = pstmt.executeQuery();

			if(rs.next()) {

				searchUser = new User();
				searchUser.setUserNumber(rs.getInt("userNumber"));
				searchUser.setUserId(rs.getString("userId"));
				searchUser.setUserPassWord(rs.getString("userPassWord"));
				searchUser.setUserName(rs.getString("userName"));
				searchUser.setUserTel(rs.getString("userTel"));
				searchUser.setUserAddress(rs.getString("userAddress"));
				searchUser.setUserClass(rs.getString("userClass"));
				searchUser.setCoupon(rs.getInt("coupon"));
				searchUser.setPurchaseQuantity(rs.getInt("purchaseQuantity"));

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

		return searchUser;

	}

	public boolean userDelete(int searchUserNumer) {

		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			String sql = "delete from system.user1 where userNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchUserNumer);
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
