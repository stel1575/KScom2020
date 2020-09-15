package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.RamCartListService;
import vo.ActionForward;
import vo.Cart;

public class RamCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		RamCartListService ramCartListService = new RamCartListService();
		ArrayList<Cart> ramcartList = ramCartListService.getCartList(request);
		
//		ramcarlistservice 나 cpu cartlistservice나 같기에 따로 만들지 아니한다.
//		그러므로 cpu 것을 쓰도록 해보는 실험
		int totalMoney = 0;
		int money = 0 ;
		
		for (int i = 0; i < ramcartList.size(); i++) {
			money = ramcartList.get(i).getPrice()*ramcartList.get(i).getQty();
			totalMoney += money;
		}

		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("ramcartList", ramcartList);
		ActionForward forward = new ActionForward("cpuCartList.jsp", false);
		//cpucartlist.jsp 를 메인 페이지로 시도하기
		return forward;
	}

}
