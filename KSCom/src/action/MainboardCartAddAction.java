package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import svc.MainboardCartAddService;
import vo.ActionForward;
import vo.Mainboard;

public class MainboardCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MainboardCartAddService mainboardCartAddService = new MainboardCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Mainboard cartMainboard = mainboardCartAddService.getCartMainboard(id);
		mainboardCartAddService.addCart(request, cartMainboard);
		ActionForward forward = new ActionForward("mainboardCartList.do", true);
		return forward;
	}

}
