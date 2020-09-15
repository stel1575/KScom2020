package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MainboardCartQtyUpService;
import vo.ActionForward;

public class MainboardCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name= request.getParameter("name");
		MainboardCartQtyUpService mainboardCartQtyUpService=new MainboardCartQtyUpService();
		mainboardCartQtyUpService.upCartQty(name,request);
		ActionForward forward=new ActionForward("mainboardCartList.do", true);
		return forward;
	}

}
