package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.CpuDAO;
import vo.Cpu;
public class CpuRegistService {

	public boolean registCpu(Cpu cpu) {
		CpuDAO cpuDAO = CpuDAO.getInstance();
		Connection con = getConnection();
		cpuDAO.setConnection(con);		
		boolean isRegistSuccess = false;		
		int insertCount = cpuDAO.insertCpu(cpu);
		
		if(insertCount>0){
			commit(con);
			isRegistSuccess=true;
		}else{
			rollback(con);
		}
		
		close(con);
		return isRegistSuccess;
	}

}
