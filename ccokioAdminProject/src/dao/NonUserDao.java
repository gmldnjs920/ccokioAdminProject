package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controllers;
import domain.NonUser;
import domain.User;

public class NonUserDao {

	public ArrayList<NonUser> nonUserSelectList() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<NonUser> nonUserList = new ArrayList<NonUser>();

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select * from system.nonUser";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				NonUser nonUser = new NonUser();
				nonUser.setNonUserNumber(rs.getInt("nonUserNumber"));
				nonUser.setNonUserName(rs.getString("nonUserName"));
				nonUser.setNonUserTel(rs.getString("nonUserTel"));
				nonUser.setNonUserAddress(rs.getString("nonUserAddress"));
				nonUserList.add(nonUser);

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

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return nonUserList;

	}

	public boolean checkNonUserNumber(int searchNonUserNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from system.nonUser where nonUserNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchNonUserNumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;

	}

	public NonUser nonUserSelectOne(int searchNonUserNumber) {

		NonUser searchNonUser = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from system.nonUser where nonUserNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchNonUserNumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				searchNonUser = new NonUser();
				searchNonUser.setNonUserNumber(rs.getInt("nonUserNumber"));
				searchNonUser.setNonUserName(rs.getString("nonUserName"));
				searchNonUser.setNonUserTel(rs.getString("nonUserTel"));
				searchNonUser.setNonUserAddress(rs.getString("nonUserAddress"));

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

		return searchNonUser;

	}

}
