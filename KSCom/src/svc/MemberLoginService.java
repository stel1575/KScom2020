package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.MemberDAO;
import vo.MemberBean;

public class MemberLoginService {

	
	  public boolean login(MemberBean member) { // TODO Auto-generated method stub
	  Connection con = getConnection(); MemberDAO memberDAO =
	  MemberDAO.getInstance(); memberDAO.setConnection(con); boolean loginResult =
	  false; String loginId = memberDAO.selectLoginId(member); if(loginId != null){
	  loginResult = true; } close(con); return loginResult; }
	  
	  public MemberBean getLoginMember(String MEMBER_ID, String MEMBER_PW) {
			// TODO Auto-generated method stub
			MemberDAO memberDAO = MemberDAO.getInstance();
			Connection con = getConnection();
			memberDAO.setConnection(con);
			MemberBean loginMember = memberDAO.selectMember(MEMBER_ID);
			close(con);
			return loginMember;
		}
	 
}
