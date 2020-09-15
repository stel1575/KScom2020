package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.GpuDAO;
import vo.Gpu;
import vo.Gpu;

public class GpuViewService {

	public Gpu getGpuView(int id) {
		Connection con=getConnection();
		GpuDAO gpuDAO=GpuDAO.getInstance();
		gpuDAO.setConnection(con);
		int updatecount=gpuDAO.updateReadCount(id);
		
		if(updatecount>0) {
			commit(con);
		}else {
			rollback(con);
		}
		Gpu gpu=gpuDAO.selectGpu(id);
		close(con);
		return gpu;
	}

}
