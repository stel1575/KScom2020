package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.RamDAO;
import vo.Ram;

public class RamViewService {
	
	public Ram getRamView(int id) {
		Connection con=getConnection();
		RamDAO ramDAO=RamDAO.getInstance();
		ramDAO.setConnection(con);
		int updatecount=ramDAO.updateReadCount(id);
		
		if(updatecount>0) {
			commit(con);
		}else {
			rollback(con);
		}
		Ram ram=ramDAO.selectRam(id);
		close(con);
		return ram;
	}

}
