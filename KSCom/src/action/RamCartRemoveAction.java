package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RamCartRemoveService;
import vo.ActionForward;

public class RamCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] nameArray = request.getParameterValues("remove");
		RamCartRemoveService ramCartRemoveService = new RamCartRemoveService();
		ramCartRemoveService.cartRemove(request,nameArray);
		ActionForward forward = new ActionForward("ramCartList.do",true);
		return forward;
	}

}
