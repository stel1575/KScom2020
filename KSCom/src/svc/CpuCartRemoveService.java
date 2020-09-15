package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import vo.Cart;

public class CpuCartRemoveService {
	
	public void cartRemove(HttpServletRequest request, String[] NameArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for (int i = 0; i < NameArray.length; i++) {
			
			for (int j = 0; j < cartList.size(); j++) {
				
				if(cartList.get(j).getName().equals(NameArray[i])){
						cartList.remove(cartList.get(j));
					
				}
				
			}
			
		}
		
	}
}