package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.CpuCartQtyDownService;
import vo.ActionForward;

public class CpuCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		System.out.println("name = " + name);
		CpuCartQtyDownService cpuCartQtyDownService = new CpuCartQtyDownService();
		cpuCartQtyDownService.downCartQty(name,request);
		ActionForward forward = new ActionForward("cpuCartList.do",true);
		return forward;
	}

}
