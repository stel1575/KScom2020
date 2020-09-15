package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MainboardDAO;
import vo.Mainboard;

public class MainboardRegistService {

	public boolean registMainboard(Mainboard mainboard) {
		MainboardDAO mainboardDAO= MainboardDAO.getInstance();
		Connection con=getConnection();
		mainboardDAO.setConnection(con);
		boolean isRegistSuccess= false;
		int insertCount= mainboardDAO.insertMainboard(mainboard);
		
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
