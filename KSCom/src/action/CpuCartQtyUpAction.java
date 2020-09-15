package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.CpuCartQtyUpService;
import vo.ActionForward;

public class CpuCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		CpuCartQtyUpService cpuCartQtyUpService = new CpuCartQtyUpService();
		cpuCartQtyUpService.upCartQty(name,request);
		ActionForward forward = new ActionForward("cpuCartList.do", true);
		return forward;
	}

}
