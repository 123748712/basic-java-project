package oJackGyuo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oJackGyuo.vo.CustomerVO;
import oracle.jdbc.driver.OracleDriver;

public class JoinDAO {
	private static JoinDAO instance = new JoinDAO();

	public static JoinDAO getInstance() {
		return instance;
	}

	private JoinDAO() {
	}

	public int insertCustomer(CustomerVO vo) throws Exception { // customer�� �ٲٱ�
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MarryWeb", "7777");
		StringBuilder builder = new StringBuilder();
		builder.append(
				" INSERT INTO MEMBER(MEM_CODE, MEM_ID, MEM_PW, MEM_NAME, MEM_AGE, MEM_PHONE, MEM_MAIL, MEM_REGNO, MEM_JENDER, MEM_MAR, MEM_POST, MEM_ADD, MEM_DAO, MEM_JOB,MEM_HINT)");
		builder.append(" VALUES ('a'||LPAD(MEMBER_SEQ.NEXTVAL,3,'0'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		PreparedStatement statement = connection.prepareStatement(builder.toString());
		statement.setString(1, vo.getCustomerId());
		statement.setString(2, vo.getCustomerPw());
		statement.setString(3, vo.getName());
		statement.setInt(4, vo.getAge());
		statement.setString(5, vo.getPhone());
		statement.setString(6, vo.getMail());
		statement.setString(7, vo.getRegno());
		statement.setString(8, vo.getJnder());
		statement.setString(9, vo.getMarry());
		statement.setInt(10, vo.getPost());
		statement.setString(11, vo.getAddress());
		statement.setString(12, vo.getAccurateaddress());
		statement.setString(13, vo.getJob());
		statement.setString(14, vo.getHint());
		int executeUpdate = statement.executeUpdate();
		statement.close();
		connection.close();
		return executeUpdate;
	}

	public List<CustomerVO> selectCustomers(CustomerVO vo) throws Exception {
		DriverManager.registerDriver(new OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MarryWeb", "7777");
		String query = "SELECT * FROM MEMBER " + " WHERE MEM_ID = ? AND MEM_PW = ?";
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, vo.getCustomerId());
		pstmt.setString(2, vo.getCustomerPw());
		ResultSet rs = pstmt.executeQuery();

		List<CustomerVO> list = new ArrayList<CustomerVO>();

		while (rs.next()) {
			list.add(makeRsToVo(rs));
		}

		return list;
	}

	// rs�� �޾Ƽ� vo�� ����
	public CustomerVO makeRsToVo(ResultSet rs) throws SQLException {
		CustomerVO vo = new CustomerVO();

		vo.setCustomerId(rs.getString("MEM_ID"));
		vo.setCustomerPw(rs.getString("MEM_PW"));
		vo.setName(rs.getString("MEM_NAME"));

		return vo;
	}
}