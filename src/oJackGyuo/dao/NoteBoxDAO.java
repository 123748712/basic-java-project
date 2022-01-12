package oJackGyuo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oJackGyuo.LoginedCustomer;
import oJackGyuo.vo.CustomerVO;
import oJackGyuo.vo.NoteBoxVO;
import oracle.jdbc.driver.OracleDriver;

public class NoteBoxDAO {
	private static NoteBoxDAO instance = new NoteBoxDAO();

	public static NoteBoxDAO getInstance() {
		return instance;
	}

	private NoteBoxDAO() {

	}
	

	public boolean selectMemId(String searchId) throws Exception {
		boolean flag = false;
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.65:1521:xe", "MarryWeb",
				"7777");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT MEM_ID FROM MEMBER WHERE MEM_ID = ?");

		PreparedStatement statement = connection.prepareStatement(builder.toString());
		
		statement.setString(1, searchId);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			flag = true;
		}
		resultSet.close();
		statement.close();
		connection.close();
		return flag;
	}

	public int insertNoteBox(NoteBoxVO note) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.45.65:1521:xe", "MarryWeb",
				"7777");
		
		LoginedCustomer loginedCustomer = LoginedCustomer.getInstance();
		
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO NOTEBOX(NB_CODE, NB_CONT, NB_TITLE, NB_DATE, NB_MEMBER, NB_SENDER)");
		builder.append("     VALUES(NOTEBOX_SEQ.NEXTVAL, ?, ?, SYSDATE, ?, ?)");

		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, note.getnBBody());
		statement.setString(2, note.getnBTitle());
		statement.setString(3, note.getnBMember());
		statement.setString(4, loginedCustomer.getLoginedCustomer().getCustomerId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
}