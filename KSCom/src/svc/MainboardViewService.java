package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MainboardDAO;
import vo.Mainboard;


public class MainboardViewService {

	public Mainboard getMainboardView(int id) {
		Connection con=getConnection();
		MainboardDAO mainboardDAO=MainboardDAO.getInstance();
		mainboardDAO.setConnection(con);
		int updatecount=mainboardDAO.updateReadCount(id);
		
		if(updatecount>0) {
			commit(con);
		}else {
			rollback(con);
		}
		Mainboard mainboard=mainboardDAO.selectMainboard(id);
		close(con);
		return mainboard;
	}

}
