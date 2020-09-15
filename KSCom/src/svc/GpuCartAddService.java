package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import dao.GpuDAO;
import vo.Cart;
import vo.Gpu;

public class GpuCartAddService {

	public Gpu getCartGpu(int id) {
		Connection con = getConnection();
		GpuDAO gpuDAO = GpuDAO.getInstance();
		gpuDAO.setConnection(con);	
		Gpu gpu = gpuDAO.selectGpu(id);
		close(con);
		return gpu;
	}

	public void addCart(HttpServletRequest request, Gpu cartGpu) {
		HttpSession session = request.getSession(); 
		ArrayList<Cart> gpucartList = (ArrayList<Cart>)session.getAttribute("gpucartList");
		
		if(gpucartList == null){
			gpucartList = new ArrayList<Cart>();
			session.setAttribute("gpucartList", gpucartList);
		}
		
		boolean isNewCart = true;
		
		
		for (int i = 0; i < gpucartList.size(); i++) {
			if(cartGpu.getName().equals(gpucartList.get(i).getName())){
				isNewCart = false;
				gpucartList.get(i).setQty(gpucartList.get(i).getQty()+1);
				break;
				
			}
		}
		
		if(isNewCart){
			Cart cart = new Cart();
			cart.setImage(cartGpu.getImage());
			cart.setName(cartGpu.getName());
			cart.setPrice(cartGpu.getPrice());
			cart.setQty(1);
			gpucartList.add(cart);
		}
		
	}
	
}