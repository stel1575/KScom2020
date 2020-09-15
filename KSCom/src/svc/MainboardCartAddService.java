package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MainboardDAO;
import vo.Cart;
import vo.Mainboard;


public class MainboardCartAddService {

	public Mainboard getCartMainboard(int id) {
		Connection con = getConnection();
		MainboardDAO mainboardDAO = MainboardDAO.getInstance();
		mainboardDAO.setConnection(con);	
		Mainboard mainboard = mainboardDAO.selectMainboard(id);
		close(con);
		return mainboard;
	}

	public void addCart(HttpServletRequest request, Mainboard cartMainboard) {
		HttpSession session = request.getSession();
		ArrayList<Cart> mainboardcartList = (ArrayList<Cart>)session.getAttribute("mainboardcartList");
		
		if(mainboardcartList == null){
			mainboardcartList = new ArrayList<Cart>();
			session.setAttribute("mainboardcartList", mainboardcartList);
		}
		
		boolean isNewCart = true;
		
		
		for (int i = 0; i < mainboardcartList.size(); i++) {
			if(cartMainboard.getName().equals(mainboardcartList.get(i).getName())){
				isNewCart = false;
				mainboardcartList.get(i).setQty(mainboardcartList.get(i).getQty()+1);
				break;
				
			}
		}
		
		if(isNewCart){
			Cart cart = new Cart();
			cart.setImage(cartMainboard.getImage());
			cart.setName(cartMainboard.getName());
			cart.setPrice(cartMainboard.getPrice());
			cart.setQty(1);
			mainboardcartList.add(cart);
		}
		
	}
	
}