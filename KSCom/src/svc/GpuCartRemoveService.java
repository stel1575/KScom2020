package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class GpuCartRemoveService {

	public void cartRemove(HttpServletRequest request, String[] nameArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> gpucartList = (ArrayList<Cart>)session.getAttribute("gpucartList");
		
		for (int i = 0; i < nameArray.length; i++) {
			
			for (int j = 0; j < gpucartList.size(); j++) {
				
				if(gpucartList.get(j).getName().equals(nameArray[i])){
						gpucartList.remove(gpucartList.get(j));
					
				}
				
			}
			
		}
		
	}
}