package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class MainboardCartListService {

	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> mainboardcartList = (ArrayList<Cart>)session.getAttribute("mainboardcartList");
		return mainboardcartList;
	}

}
