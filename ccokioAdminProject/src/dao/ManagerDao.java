package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.Controllers;
import domain.Manager;
import domain.User;

public class ManagerDao {

	public boolean managerRegister(Manager newManager) {

		Statement stmt = null;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null, rs2 = null;
		boolean success = false;

		try {

			String sql = "select * from managers where managerId = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setString(1, newManager.getManagerId());
			rs = pstmt.executeQuery();

			if(rs.next()) {

			} else {

				sql = "insert into managers(managerNumber, managerId, managerPassword, managerName) values(Managers_managerNumber_seq.nextval, ?, ?, ?)";
				pstmt2 = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt2.setString(1, newManager.getManagerId());
				pstmt2.setString(2, newManager.getManagerPassWord());
				pstmt2.setString(3, newManager.getManagerName());

				int result = pstmt2.executeUpdate();

				if(result != 0) {
					success = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt2 != null) { try { pstmt2.close();} catch (SQLException e) { e.printStackTrace();}
			}
			if(rs2 != null) { try { rs2.close();} catch (SQLException e) { e.printStackTrace();}
			}
			if(stmt != null) { try { stmt.close();} catch (SQLException e) { e.printStackTrace();}
			}
			if(rs != null) { try { rs.close();} catch (SQLException e) { e.printStackTrace();}
			}
			if(pstmt != null) {	try { pstmt.close();} catch (SQLException e) { e.printStackTrace();}
			}

		}

		return success;

	}
	
	public ArrayList<Manager> managerSelectList() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Manager> managerList = new ArrayList<Manager>();

		try {

			stmt = Controllers.getProgramController().getConnection().createStatement();
			String sql = "select * from managers";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {

				Manager manager = new Manager();
				manager.setManagerNumber(rs.getInt("managerNumber"));
				manager.setManagerId(rs.getString("managerId"));
				manager.setManagerPassWord(rs.getString("managerPassWord"));
				manager.setManagerName(rs.getString("managerName"));
				manager.setManagerFlag(rs.getInt("managerFlag"));
				managerList.add(manager);

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

		return managerList;
	}

	public boolean checkManagerNumber(int searchManagerNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from managers where managerNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchManagerNumber);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return success;

	}

	public Manager managerSelectOne(int searchManagerNumber) {

		Manager searchManager = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from managers where managerNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchManagerNumber);
			rs = pstmt.executeQuery();

			if(rs.next()) {

				searchManager = new Manager();
				searchManager.setManagerNumber(rs.getInt("managerNumber"));
				searchManager.setManagerId(rs.getString("managerId"));
				searchManager.setManagerPassWord(rs.getString("managerPassWord"));
				searchManager.setManagerName(rs.getString("managerName"));
				searchManager.setManagerFlag(rs.getInt("managerFlag"));

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

		return searchManager;

	}
	
	public boolean managerUpdate(Manager searchManger, int selectedMenu) {

		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = null;

		try {

			if(selectedMenu == 1) {

				sql = "update managers set managerPassWord = ? where managerNumber = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setString(1, searchManger.getManagerPassWord());
				pstmt.setInt(2, searchManger.getManagerNumber());
				result = pstmt.executeUpdate();

			} else if(selectedMenu == 2) {

				sql = "update managers set managerName = ? where managerNumber = ?";
				pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
				pstmt.setString(1, searchManger.getManagerName());
				pstmt.setInt(2, searchManger.getManagerNumber());
				result = pstmt.executeUpdate();
			}

			if(result != 0) {
				success = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) { try { pstmt.close();} catch (SQLException e) { e.printStackTrace();}
			}
		}

		return success;
	}
	
	public Manager managerInfo(int searchManagerNumber) {

		Manager searchManager = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select * from Managers where managerNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchManagerNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				searchManager = new Manager();
				searchManager.setManagerNumber(rs.getInt("managerNumber"));
				searchManager.setManagerId(rs.getString("managerId"));
				searchManager.setManagerPassWord(rs.getString("managerPassWord"));
				searchManager.setManagerName(rs.getString("managerName"));
				searchManager.setManagerFlag(rs.getInt("managerFlag"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			if(rs != null) { try { rs.close();} catch (SQLException e) { e.printStackTrace();}
			}
			if(pstmt != null) { try { pstmt.close();} catch (SQLException e) { e.printStackTrace();}
			}
		}
		
		return searchManager;
	}

	public boolean managerDelete(int searchManagerNumber) {

		boolean success = false;
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			String sql = "delete from managers where managerNumber = ?";
			pstmt = Controllers.getProgramController().getConnection().prepareStatement(sql);
			pstmt.setInt(1, searchManagerNumber);
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
