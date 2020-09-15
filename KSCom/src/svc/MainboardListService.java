package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.MainboardDAO;
import vo.Mainboard;


public class MainboardListService {

	public static ArrayList<Mainboard> getMainboardList() {
		MainboardDAO mainboardDAO= MainboardDAO.getInstance();
		Connection con =getConnection();
		mainboardDAO.setConnection(con);
		ArrayList<Mainboard> mainboardList=mainboardDAO.selectMainboardList();
		close(con);
		return mainboardList;
	}

}
