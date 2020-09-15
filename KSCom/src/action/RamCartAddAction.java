package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import svc.RamCartAddService;
import vo.ActionForward;
import vo.Ram;

public class RamCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		RamCartAddService ramCartAddService = new RamCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Ram cartRam = ramCartAddService.getCartRam(id);
		ramCartAddService.addCart(request, cartRam);
		ActionForward forward = new ActionForward("ramCartList.do", true);
		return forward;
	}

}
