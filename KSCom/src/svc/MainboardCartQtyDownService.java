package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class MainboardCartQtyDownService {

	public void downCartQty(String name, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> mainboardcartList = (ArrayList<Cart>)session.getAttribute("mainboardcartList");
		
		for (int i = 0; i < mainboardcartList.size(); i++) {
			
			if(mainboardcartList.get(i).getName().equals(name)){
				mainboardcartList.get(i).setQty(mainboardcartList.get(i).getQty()-1);
			}
			
		}
		
	}

}
