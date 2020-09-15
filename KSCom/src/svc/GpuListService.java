package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GpuDAO;
import vo.Gpu;
import vo.Gpu;

public class GpuListService {

	public ArrayList<Gpu> getGpuList() {
		GpuDAO gpuDAO= GpuDAO.getInstance();
		Connection con =getConnection();
		gpuDAO.setConnection(con);
		ArrayList<Gpu> gpuList= gpuDAO.selectGpuList();
		close(con);
		return gpuList;
		
	}

	
}
