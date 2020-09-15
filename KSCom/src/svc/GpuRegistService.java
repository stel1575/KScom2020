package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.GpuDAO;
import vo.Gpu;

public class GpuRegistService {

	public boolean registGpu(Gpu gpu) {
		GpuDAO gpuDAO= GpuDAO.getInstance();
		Connection con=getConnection();
		gpuDAO.setConnection(con);
		boolean isRegistSuccess= false;
		int insertCount= gpuDAO.insertGpu(gpu);
		
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
