package oJackGyuo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	public int sendNote(NoteBoxVO note) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MarryWeb", "7777");
		StringBuilder builder = new StringBuilder();
		builder.append(" INSERT INTO NOTEBOX");
		builder.append("     (NB_CODE, NB_CONT, NB_TITLE, NB_DATE, NB_MEMBER)");
		builder.append("     VALUES");
		builder.append("         (NOTEBOX_SEQ.NEXTVAL, ?, ?, SYSDATE, ?)");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, note.getnBBody());
		statement.setString(2, note.getnBTitle());
		statement.setString(3, note.getSendId());
		// 받는사람 사라짐
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}

	public int viewNoteBox(CustomerVO loginedCustomer) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MarryWeb", "7777");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    *");
		builder.append(" FROM NOTEBOX");
		builder.append(" WHERE");
		builder.append("     NB_MEMBER = ?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, loginedCustomer.getCustomerId()); // 로그인 되어있는 상태의 아이디
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}

	public int detailNote(CustomerVO loginedCustomer) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MarryWeb", "7777");
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT NB_TITLE");
		builder.append("     , NB_CONT");
		builder.append(" FROM NOTEBOX");
		builder.append(" WHERE");
		builder.append("	NB_MEMBER = ?");
		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, loginedCustomer.getCustomerId());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}
}