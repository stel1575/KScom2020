package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vo.Ram;
import static db.JdbcUtil.*;

public class RamDAO {

	Connection con;
	private static RamDAO boardDAO;

	public static RamDAO getInstance() {
		if (boardDAO == null) {
			boardDAO = new RamDAO();
		}
		return boardDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;

	}
//RamList
	public ArrayList<Ram> selectRamList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Ram> ramList = null;
		try {
			pstmt=con.prepareStatement("select *from ram");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				ramList=new ArrayList<Ram>();
				do {
					ramList.add(new Ram(
							rs.getInt("id")
							,rs.getString("brand")
							,rs.getString("name")
							,rs.getString("clock")
							,rs.getString("capacity")
							,rs.getString("image")
							,rs.getInt("price")
							,rs.getString("content")
							,rs.getInt("readcount")
							));
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("ramlist 출력 부분"+e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return ramList;
	}
//ram 등록하는 부분
	public int insertRam(Ram ram) {
		PreparedStatement pstmt= null;
		int insertCount=0;
		String sql="";
		try {
			sql="insert into ram(brand,name,clock,capacity,image,price,content,readcount) values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ram.getBrand());
			pstmt.setString(2, ram.getName());
			pstmt.setString(3, ram.getClock());
			pstmt.setString(4, ram.getCapacity());
			pstmt.setString(5, ram.getImage());
			pstmt.setInt(6, ram.getPrice());
			pstmt.setString(7, ram.getContent());
			pstmt.setInt(8, ram.getReadcount());
			insertCount=pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("insertram 다오 부분"+e);
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
//ram 조회수 부분 1씩 증가하게한다
	public int updateReadCount(int id) {
		PreparedStatement pstmt=null;
		int updateCount=0;
		String sql="";
		
		try {
			sql="update ram set readcount =readcount +1 where id=?";
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
//각 아이디의 램 정보 불러오기
	public Ram selectRam(int id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		Ram ram=null;
		
		try {
			pstmt= con.prepareStatement("select * from ram where id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				ram=new Ram(
						rs.getInt("id")
						,rs.getString("brand")
						,rs.getString("name")
						,rs.getString("clock")
						,rs.getString("capacity")
						,rs.getString("image")
						,rs.getInt("price")
						,rs.getString("content")
						,rs.getInt("readcount"));
						
			}
			
		}catch (SQLException e) {
			System.out.println("selectRam 부분 "+e);
		}finally {
			close(pstmt);
			close(rs);
		}
		return ram;
	}
	
	
	
}