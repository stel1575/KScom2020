package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class MainboardCartRemoveService {

	public void cartRemove(HttpServletRequest request, String[] nameArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> mainboardcartList = (ArrayList<Cart>)session.getAttribute("mainboardcartList");
		
		for (int i = 0; i < nameArray.length; i++) {
			
			for (int j = 0; j < mainboardcartList.size(); j++) {
				
				if(mainboardcartList.get(j).getName().equals(nameArray[i])){
						mainboardcartList.remove(mainboardcartList.get(j));
					
				}
				
			}
			
		}
		
	}
}