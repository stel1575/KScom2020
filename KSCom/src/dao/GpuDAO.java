package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Gpu;


public class GpuDAO {

	Connection con;
	private static GpuDAO boardDAO;
	public static GpuDAO getInstance() {
		if(boardDAO ==null) {
			boardDAO= new GpuDAO();
		}
		return boardDAO;
	}

	public void setConnection(Connection con) {
		this.con=con;
		
	}

	public Gpu selectGpu(int id) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		Gpu gpu=null;
		
		try {
			pstmt= con.prepareStatement("select * from gpu where id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				gpu=new Gpu(
						rs.getInt("id")
						,rs.getString("brand")
						,rs.getString("detail_chipset")
						,rs.getString("chipset_maker")
						,rs.getString("vram")
						,rs.getString("image")
						,rs.getString("name")
						,rs.getInt("price")
						,rs.getString("content")
						,rs.getInt("readcount"));
						
						
			}
			
		}catch (SQLException e) {
			System.out.println("selectGpu 부분 "+e);
		}finally {
			close(pstmt);
			close(rs);
		}
		return gpu;
	}

	public ArrayList<Gpu> selectGpuList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Gpu> gpuList = null;
		try {
			pstmt=con.prepareStatement("select *from gpu");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				gpuList=new ArrayList<Gpu>();
				do {
					gpuList.add(new Gpu(
							rs.getInt("id")
							,rs.getString("brand")
							,rs.getString("detail_chipset")
							,rs.getString("chipset_maker")
							,rs.getString("vram")
							,rs.getString("image")
							,rs.getString("name")
							,rs.getInt("price")
							,rs.getString("content")
							,rs.getInt("readcount")));
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("gpulist 출력 부분"+e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return gpuList;
	}

	public int insertGpu(Gpu gpu) {
		PreparedStatement pstmt= null;
		int insertCount=0;
		String sql="";
		try {
			sql="insert into gpu(brand,chipset_maker,detail_chipset,vram,image,name,price,content,readcount) values(?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, gpu.getBrand());
			pstmt.setString(2, gpu.getChipset_maker());
			pstmt.setString(3, gpu.getDetail_chipset());
			pstmt.setString(4, gpu.getVram());
			pstmt.setString(5, gpu.getImage());
			pstmt.setString(6, gpu.getName());
			pstmt.setInt(7, gpu.getPrice());
			pstmt.setString(8, gpu.getContent());
			pstmt.setInt(9, gpu.getReadcount());
			insertCount=pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("insertgpu 다오 부분"+e);
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}

	public int updateReadCount(int id) {
		PreparedStatement pstmt=null;
		int updateCount=0;
		String sql="";
		
		try {
			sql="update gpu set readcount =readcount +1 where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			updateCount=pstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("조회수 업데이트 부분"+e);
		}finally {
			close(pstmt);
		}
		return updateCount;
	}

}
