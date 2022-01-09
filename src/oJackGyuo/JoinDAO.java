package sioon.marryweb.join;

import org.springframework.jdbc.core.JdbcTemplate;

import sioon.marryweb.MarryWeb;

public class JoinDAO {
	private static JoinDAO instance = new JoinDAO();
	public static JoinDAO getInstance() {
		return instance;
	}
	
	private JoinDAO() {}
	
	private JdbcTemplate template = MarryWeb.getTemplate();
	
	public int join(CustomerVO vo) {
		return template.update("INSERT INTO MEMBER(MEM_ID,MEM_PW,MEM_NAME,MEM_AGE,MEM_PHONE,MEM_MAIL,MEM_REGNO1,MEM_REGNO2,MEM_JENDER,MEM_MAR,MEM_POST,MEM_ADD,\r\n"
				+ "MEM_DAO,MEM_JOB,MEM_HINT) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", vo.getCustomerid(),vo.getPassword(),vo.getName(),vo.getAge(),vo.getPhone(),vo.getMail(),vo.getRegno1(),vo.getRegno2(),vo.getJnder(),vo.getMarry(),vo.getPost()
				,vo.getAddress(),vo.getAccurateaddress(),vo.getJob(),vo.getHint());
	}
	public int modifyName(CustomerVO vo) {
        return template.update("UPDATE MEMBER SET MEM_NAME = ? WHERE MEM_ID = ?", vo.getName(), vo.getCustomerid());
    }
	public int modifyAge(CustomerVO vo) {
        return template.update("UPDATE MEMBER SET MEM_AGE = ? WHERE MEM_ID = ?", vo.getAge(), vo.getCustomerid());
    }
	public int modifyPhone(CustomerVO vo) {
        return template.update("UPDATE MEMBER SET MEM_PHONE = ? WHERE MEM_ID = ?", vo.getPhone(), vo.getCustomerid());
    }
	public int modifyPassWord(CustomerVO vo) {
        return template.update("UPDATE MEMBER SET MEM_PW = ? WHERE MEM_ID = ?", vo.getPassword(), vo.getCustomerid());
    }
	public int modifyMail(CustomerVO vo) {
        return template.update("UPDATE MEMBER SET MEM_MAIL = ? WHERE MEM_ID = ?", vo.getMail(), vo.getCustomerid());
    }
	public int modifyMarry(CustomerVO vo) {
        return template.update("UPDATE MEMBER SET MEM_MAR = ? WHERE MEM_ID = ?", vo.getMarry(), vo.getCustomerid());
    }
	public int modifyJob(CustomerVO vo) {
		return template.update("UPDATE MEMBER SET MEM_JOB = ? WHERE MEM_ID = ?", vo.getJob(), vo.getCustomerid());
	}
}
