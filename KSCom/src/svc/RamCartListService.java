package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class RamCartListService {

	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> ramcartList = (ArrayList<Cart>)session.getAttribute("ramcartList");
		return ramcartList;
	}

}
