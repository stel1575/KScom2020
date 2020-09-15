package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class GpuCartQtyDownService {

	public void downCartQty(String name, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> gpucartList = (ArrayList<Cart>)session.getAttribute("gpucartList");
		
		for (int i = 0; i < gpucartList.size(); i++) {
			
			if(gpucartList.get(i).getName().equals(name)){
				gpucartList.get(i).setQty(gpucartList.get(i).getQty()-1);
			}
			
		}
		
	}

}
