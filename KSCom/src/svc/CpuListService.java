package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.CpuDAO;
import vo.Cpu;

public class CpuListService {

	public ArrayList<Cpu> getCpuList() {
		CpuDAO cpuDAO = CpuDAO.getInstance();
		Connection con = getConnection();
		cpuDAO.setConnection(con);		
		ArrayList<Cpu> cpuList = cpuDAO.selectCpuList();
		close(con);
		return cpuList;
	}
	
	
}