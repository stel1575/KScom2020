package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RamCartQtyDownService;
import vo.ActionForward;

public class RamCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		System.out.println("name = " + name);
		RamCartQtyDownService ramCartQtyDownService = new RamCartQtyDownService();
		ramCartQtyDownService.downCartQty(name,request);
		ActionForward forward = new ActionForward("ramCartList.do",true);
		return forward;
	}

}
