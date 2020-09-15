package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;
import vo.Cpu;

public class CpuDAO {
	
	Connection con;
	private static CpuDAO boardDAO;
	
	private CpuDAO() {
		
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public static CpuDAO getInstance(){
		
		if(boardDAO ==null){
			boardDAO = new CpuDAO();
		}
		
		return boardDAO;
	}
	//cpu리스트
	public ArrayList<Cpu> selectCpuList() {
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		ArrayList<Cpu> cpuList = null;
		
		try {
			pstmt = con.prepareStatement("SELECT * FROM cpu");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cpuList = new ArrayList<Cpu>();
				
				do {
					cpuList.add(new Cpu(
							rs.getInt("id")
							,rs.getString("name")
							,rs.getString("core")
							,rs.getString("cpu_package")
							,rs.getString("image")
							,rs.getInt("price")
							,rs.getString("content")
							,rs.getInt("readcount")));
				} while (rs.next());
				
			}
			
		} catch (SQLException e) {
			System.out.println("cpulist 출력 부분"+e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return cpuList;
	}
	
//cpu 부분 id 
	public Cpu selectCpu(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Cpu cpu = null;
		
		try {
			pstmt = con.prepareStatement("select * from cpu where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				cpu = new Cpu(
						rs.getInt("id")
						,rs.getString("name")
						,rs.getString("core")
						,rs.getString("cpu_package")
						,rs.getString("image")
						,rs.getInt("price")
						,rs.getString("content")
						,rs.getInt("readcount"));
			}
			
		} catch (SQLException e) {
			System.out.println("selectCPU 부분 오류"+e);
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return cpu;
	}
//cpu 조회수 업데이트? cpu및 모든 조회수로 해보자	
	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		
		try {
			sql = "update cpu set readcount = readcount + 1 where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("조회수업데이트 다오 부분"+e);
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
//cpu 등록
	public int insertCpu(Cpu cpu) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";
		
		try {
			sql = "insert into cpu(name,core,cpu_package,image,price,content,readcount)values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cpu.getName());
			pstmt.setString(2, cpu.getCore());
			pstmt.setString(3, cpu.getCpu_package());
			pstmt.setString(4, cpu.getImage());
			pstmt.setInt(5, cpu.getPrice());
			pstmt.setString(6, cpu.getContent());
			pstmt.setInt(7, cpu.getReadcount());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertcpu 다오 부분"+e);
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
}
