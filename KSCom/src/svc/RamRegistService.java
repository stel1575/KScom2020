package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.RamDAO;
import vo.Ram;

public class RamRegistService {

	public static boolean registRam(Ram ram) {
		// TODO Auto-generated method stub
		RamDAO ramDAO= RamDAO.getInstance();
		Connection con=getConnection();
		ramDAO.setConnection(con);
		boolean isRegistSuccess= false;
		int insertCount= ramDAO.insertRam(ram);
		
		if(insertCount>0) {
			commit(con);
			isRegistSuccess=true;
		}else {
			rollback(con);
		}
		close(con);
		return isRegistSuccess;
	}

}
