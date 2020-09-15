package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CpuCartAddService;
import vo.ActionForward;
import vo.Cpu;

public class CpuCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CpuCartAddService cpuCartAddService = new CpuCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Cpu cartCpu = cpuCartAddService.getCartCpu(id);
		cpuCartAddService.addCart(request, cartCpu);
		ActionForward forward = new ActionForward("cpuCartList.do", true);
		return forward;
	}

}
