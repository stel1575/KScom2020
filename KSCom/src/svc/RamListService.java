package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.RamDAO;

import static db.JdbcUtil.*;

import vo.Ram;

public class RamListService {

	public ArrayList<Ram> getRamList() {
		RamDAO ramDAO= RamDAO.getInstance();
		Connection con =getConnection();
		ramDAO.setConnection(con);
		ArrayList<Ram> ramList= ramDAO.selectRamList();
		close(con);
		return ramList;
		
	}

	
}
