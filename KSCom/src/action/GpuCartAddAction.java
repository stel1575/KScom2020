package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import svc.GpuCartAddService;
import vo.ActionForward;
import vo.Gpu;

public class GpuCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GpuCartAddService gpuCartAddService = new GpuCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Gpu cartGpu = gpuCartAddService.getCartGpu(id);
		gpuCartAddService.addCart(request, cartGpu);
		ActionForward forward = new ActionForward("gpuCartList.do", true);
		return forward;
	}

}
