package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Controllers;
import domain.Login;
import repository.LoginRepository;

public class LoginDao {

	public LoginDao() {
		new LoginRepository();
	}

	public boolean login(Login login) {

		boolean success = false;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null, rs2 = null;

		try {

			String sql = "select * from system.Managers where managerId = ? and managerPassword = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, login.getLoginId());
			pstmt.setString(2, login.getLoginPassWord());
			rs = pstmt.executeQuery();

			if(rs.next()) {
				login.setLoginFlag(rs.getInt("ManagerFlag"));
				LoginRepository.setLogin(login);
				success = true;
				
			} 
			else {
				sql = "select  * from Admin1 where AdminId = ? and AdminPassword = ?";
				pstmt2 = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt2.setString(1, login.getLoginId());
				pstmt2.setString(2, login.getLoginPassWord());
				rs2 = pstmt2.executeQuery();

				if(rs2.next()) {
					login.setLoginFlag(rs2.getInt("AdminFlag"));
					LoginRepository.setLogin(login);
					success = true;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs2 != null) {
				try { rs2.close();} catch (SQLException e) { e.printStackTrace();}
			}
			if(pstmt2 != null) { try { pstmt2.close();} catch (SQLException e) { e.printStackTrace();}
			}
			if(rs != null) {
				try { rs.close();} catch (SQLException e) { e.printStackTrace();}
			}
			if(pstmt != null) { try { pstmt.close();} catch (SQLException e) { e.printStackTrace();}
			}
		}

		return success;
	}

	public int checkLogin() {

		int loginFlag = 0;

		if(LoginRepository.getLogin() != null) {
			if(LoginRepository.getLogin().getLoginFlag() == 1) {
				loginFlag = 1;
			}
			else if(LoginRepository.getLogin().getLoginFlag() == 0) {
				loginFlag = 0;
			}
		}

		return loginFlag;
	}

	public boolean logout() {

		boolean success = false;
		LoginRepository.setLogin(null);
		Controllers.getProgramController().requestConnectionAdmin();
		success = true;

		return success;

	}

}
