package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class RamCartQtyDownService {

	public void downCartQty(String name, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> ramcartList = (ArrayList<Cart>)session.getAttribute("ramcartList");
		
		for (int i = 0; i < ramcartList.size(); i++) {
			
			if(ramcartList.get(i).getName().equals(name)){
				ramcartList.get(i).setQty(ramcartList.get(i).getQty()-1);
			}
			
		}
		
	}

}
