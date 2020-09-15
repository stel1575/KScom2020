package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class GpuCartListService {

	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> gpucartList = (ArrayList<Cart>)session.getAttribute("gpucartList");
		return gpucartList;
	}

}
