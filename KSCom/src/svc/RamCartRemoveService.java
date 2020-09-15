package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class RamCartRemoveService {

	public void cartRemove(HttpServletRequest request, String[] nameArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> ramcartList = (ArrayList<Cart>)session.getAttribute("ramcartList");
		
		for (int i = 0; i < nameArray.length; i++) {
			
			for (int j = 0; j < ramcartList.size(); j++) {
				
				if(ramcartList.get(j).getName().equals(nameArray[i])){
						ramcartList.remove(ramcartList.get(j));
					
				}
				
			}
			
		}
		
	}
}