package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;
import vo.Cpu;
import dao.CpuDAO;

public class CpuCartAddService {

	public Cpu getCartCpu(int id) {
		Connection con = getConnection();
		CpuDAO cpuDAO = CpuDAO.getInstance();
		cpuDAO.setConnection(con);	
		Cpu cpu = cpuDAO.selectCpu(id);
		close(con);
		return cpu;
	}

	public void addCart(HttpServletRequest request, Cpu cartCpu) {
		HttpSession session = request.getSession(); 
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null){
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		
		
		for (int i = 0; i < cartList.size(); i++) {
			if(cartCpu.getName().equals(cartList.get(i).getName())){
				isNewCart = false;
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
				break;
				
			}
		}
		
		if(isNewCart){
			Cart cart = new Cart();
			cart.setImage(cartCpu.getImage());
			cart.setName(cartCpu.getName());
			cart.setPrice(cartCpu.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
		
	}
	
}