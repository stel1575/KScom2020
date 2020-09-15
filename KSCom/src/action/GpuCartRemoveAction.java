package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GpuCartRemoveService;
import vo.ActionForward;

public class GpuCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] nameArray = request.getParameterValues("remove");
		GpuCartRemoveService gpuCartRemoveService = new GpuCartRemoveService();
		gpuCartRemoveService.cartRemove(request,nameArray);
		ActionForward forward = new ActionForward("gpuCartList.do",true);
		return forward;
	}

}
