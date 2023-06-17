package in.bhel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.bhel.dao.CableStoreDao;
import in.bhel.db.JDBCUtil;
import in.bhel.entity.CableStore;

public class CableStoreImpl implements CableStoreDao {
	
	private Connection connection = null;
	private PreparedStatement pstmt = null;
	private ResultSet resultSet = null;

	@Override
	public boolean insertDrumToStore(CableStore cs) {
		
		boolean flag = false;
		
		try {
			
			connection = JDBCUtil.getJdbcConnection();	
			String sqlInsertQuery = "insert into drumatstore (`length`, `dbNo`, `dbDate`, `cableCode`, `drumNo`, `uniqueCode`) values (?,?,?,?,?,?)";
			pstmt = connection.prepareStatement(sqlInsertQuery);
			pstmt.setDouble(1, cs.getLength());
			pstmt.setDouble(2, cs.getDbNo());
			pstmt.setString(3, cs.getDbDate());
			pstmt.setString(4, cs.getCableCode());
			pstmt.setString(5, cs.getDrumNo());
			pstmt.setString(6, cs.getUniqueCode());
			flag = pstmt.execute();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}	
		try {
			JDBCUtil.cleanUp(connection, pstmt, resultSet);
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public String updateDateByDb(double dbNo, String date) {
		// TODO Auto-generated method stub
		
		int i = 0;
		
		try {
			
			connection = JDBCUtil.getJdbcConnection();	
			String sqlInsertQuery = "update drumatstore set dbDate = ? where dbNo = ?";
			pstmt = connection.prepareStatement(sqlInsertQuery);
			pstmt.setString(1, date);
			pstmt.setDouble(2, dbNo);
			i = pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}	
		try {
			JDBCUtil.cleanUp(connection, pstmt, resultSet);
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		return "No of records updated are " + i;
	}

	@Override
	public String updateUniqueCode() {
		// TODO Auto-generated method stub
int i = 0;
		
		try {
			
			connection = JDBCUtil.getJdbcConnection();
			String sqlSelectQuery = "select * from drumatstore";
			pstmt = connection.prepareStatement(sqlSelectQuery);
			resultSet = pstmt.executeQuery();
			while(resultSet.next()) {
				String sqlInsertQuery = "update drumatstore set uniqueCode = ? where sno = ?";
				pstmt = connection.prepareStatement(sqlInsertQuery);
				pstmt.setString(1,resultSet.getDouble("dbNO") + " " + resultSet.getString("drumNo"));
				pstmt.setDouble(2, resultSet.getInt("sno"));
				i = pstmt.executeUpdate();
			}
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}	
		try {
			JDBCUtil.cleanUp(connection, pstmt, resultSet);
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		return "No of records updated are " + i;
	}

}
