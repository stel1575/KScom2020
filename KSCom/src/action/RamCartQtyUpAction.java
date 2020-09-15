package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RamCartQtyUpService;
import vo.ActionForward;

public class RamCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name= request.getParameter("name");
		RamCartQtyUpService ramCartQtyUpService=new RamCartQtyUpService();
		ramCartQtyUpService.upCartQty(name,request);
		ActionForward forward=new ActionForward("ramCartList.do", true);
		return forward;
	}

}
