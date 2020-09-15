package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MainboardCartRemoveService;
import vo.ActionForward;

public class MainboardCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] nameArray = request.getParameterValues("remove");
		MainboardCartRemoveService mainboardCartRemoveService = new MainboardCartRemoveService();
		mainboardCartRemoveService.cartRemove(request,nameArray);
		ActionForward forward = new ActionForward("mainboardCartList.do",true);
		return forward;
	}

}
