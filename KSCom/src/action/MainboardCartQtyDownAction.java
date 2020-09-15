package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MainboardCartQtyDownService;
import vo.ActionForward;

public class MainboardCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		System.out.println("name = " + name);
		MainboardCartQtyDownService mainboardCartQtyDownService = new MainboardCartQtyDownService();
		mainboardCartQtyDownService.downCartQty(name,request);
		ActionForward forward = new ActionForward("mainboardCartList.do",true);
		return forward;
	}

}
