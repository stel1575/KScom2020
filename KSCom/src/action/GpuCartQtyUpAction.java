package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GpuCartQtyUpService;
import vo.ActionForward;

public class GpuCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name= request.getParameter("name");
		GpuCartQtyUpService gpuCartQtyUpService=new GpuCartQtyUpService();
		gpuCartQtyUpService.upCartQty(name,request);
		ActionForward forward=new ActionForward("gpuCartList.do", true);
		return forward;
	}

}
