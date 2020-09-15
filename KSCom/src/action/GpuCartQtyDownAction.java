package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GpuCartQtyDownService;
import vo.ActionForward;

public class GpuCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		System.out.println("name = " + name);
		GpuCartQtyDownService gpuCartQtyDownService = new GpuCartQtyDownService();
		gpuCartQtyDownService.downCartQty(name,request);
		ActionForward forward = new ActionForward("gpuCartList.do",true);
		return forward;
	}

}
