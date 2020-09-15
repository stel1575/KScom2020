package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import vo.Cpu;
import dao.CpuDAO;
public class CpuViewService {

	public Cpu getCpuView(int id) {
		Connection con = getConnection();
		CpuDAO cpuDAO = CpuDAO.getInstance();
		cpuDAO.setConnection(con);	
		int updateCount = cpuDAO.updateReadCount(id);
		
		if(updateCount>0){
			commit(con);
		}else{
			rollback(con);
		}
		
		Cpu cpu = cpuDAO.selectCpu(id);
		close(con);
		return cpu;
	}

}
