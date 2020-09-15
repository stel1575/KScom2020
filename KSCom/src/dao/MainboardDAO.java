package dao;


import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Mainboard;
import vo.Mainboard;

public class MainboardDAO {
	
	Connection con;
	private static MainboardDAO boardDao;

	//이메소드 호출없이는 dao 호출 불가능하게 만들었다,첨 요청에게만 객체생성후 담객체때는 레퍼런스 값공유
	public static MainboardDAO getInstance() {
		if(boardDao ==null) {
			boardDao=new MainboardDAO();
		}return boardDao;
	}

	public void setConnection(Connection con) {
		this.con=con;
		
	}

	public ArrayList<Mainboard> selectMainboardList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Mainboard> mainboardList = null;
		try {
			pstmt=con.prepareStatement("select *from mainboard");
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				mainboardList=new ArrayList<Mainboard>();
				do {
					mainboardList.add(new Mainboard(
							rs.getInt("id")
							,rs.getString("brand")
							,rs.getString("name")
							,rs.getString("kind")
							,rs.getString("socket")
							,rs.getString("chipset")
							,rs.getString("form_factor")
							,rs.getString("image")
							,rs.getInt("price")
							,rs.getString("content")
							,rs.getInt("readcount")
							));
							 
				}while(rs.next());
			}
		} catch (SQLException e) {
			System.out.println("mainboardlist 출력 부분"+e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return mainboardList;
	}

	public int updateReadCount(int id) {
		PreparedStatement pstmt=null;
		int updateCount=0;
		String sql="";
		
		try {
			sql="update mainboard set readcount =readcount +1 where id=?";
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

	public Mainboard selectMainboard(int id) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		Mainboard mainboard=null;
		
		try {
			pstmt= con.prepareStatement("select * from mainboard where id=?");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				mainboard=new Mainboard(
						rs.getInt("id")
						,rs.getString("brand")
						,rs.getString("name")
						,rs.getString("kind")
						,rs.getString("socket")
						,rs.getString("chipset")
						,rs.getString("form_factor")
						,rs.getString("image")
						,rs.getInt("price")
						,rs.getString("content")
						,rs.getInt("readcount")
						);
						
			}
			
		}catch (SQLException e) {
			System.out.println("selectMainboard 부분 "+e);
		}finally {
			close(pstmt);
			close(rs);
		}
		return mainboard;
	}

	public int insertMainboard(Mainboard mainboard) {
		PreparedStatement pstmt= null;
		int insertCount=0;
		String sql="";
		try {
			sql="insert into mainboard(brand,name,kind,socket,chipset,form_factor,image,price,content,readcount)"
					+"values(?,?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mainboard.getBrand());
			pstmt.setString(2, mainboard.getName());
			pstmt.setString(3, mainboard.getKind());
			pstmt.setString(4, mainboard.getSocket());
			pstmt.setString(5, mainboard.getChipset());
			pstmt.setString(6, mainboard.getForm_factor());
			pstmt.setString(7, mainboard.getImage());
			pstmt.setInt(8, mainboard.getPrice());
			pstmt.setString(9, mainboard.getContent());
			pstmt.setInt(10, mainboard.getReadcount());
			insertCount=pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("insertMainboard 다오 부분"+e);
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}

	

}
