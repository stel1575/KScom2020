package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

public class CpuCartQtyUpService {

	public void upCartQty(String Name, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for (int i = 0; i < cartList.size(); i++) {
			
			if(cartList.get(i).getName().equals(Name)){
				cartList.get(i).setQty(cartList.get(i).getQty()+1);
			}
			
		}
		
	}
	
}
