package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.CpuCartListService;
import vo.ActionForward;
import vo.Cart;

public class CpuCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CpuCartListService cpuCartListService = new CpuCartListService();
		ArrayList<Cart> cartList = cpuCartListService.getCartList(request);
		
		int totalMoney = 0;
		int money = 0 ;
	try {	
		if(cartList.size()!=0) {
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney += money;
		}
		}
	}catch (Exception e) {
		System.out.println("씨피유카트리스트엑션부분"+e);
		
		
	}
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("cpuCartList.jsp", false);
		return forward;
	}

}
