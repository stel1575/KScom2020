package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GpuCartListService;
import vo.ActionForward;
import vo.Cart;

public class GpuCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GpuCartListService gpuCartListService = new GpuCartListService();
		ArrayList<Cart> gpucartList = gpuCartListService.getCartList(request);
		
//		ramcarlistservice 나 cpu cartlistservice나 같기에 따로 만들지 아니한다.
//		그러므로 cpu 것을 쓰도록 해보는 실험
		int totalMoney = 0;
		int money = 0 ;
		
		for (int i = 0; i < gpucartList.size(); i++) {
			money = gpucartList.get(i).getPrice()*gpucartList.get(i).getQty();
			totalMoney += money;
		}

		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("gpucartList", gpucartList);
		ActionForward forward = new ActionForward("cpuCartList.jsp", false);
		//cpucartlist.jsp 를 메인 페이지로 시도하기
		return forward;
	}

}
