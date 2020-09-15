package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.CpuCartRemoveService;
import vo.ActionForward;

public class CpuCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] nameArray = request.getParameterValues("remove");
		CpuCartRemoveService cpuCartRemoveService = new CpuCartRemoveService();
		cpuCartRemoveService.cartRemove(request,nameArray);
		ActionForward forward = new ActionForward("cpuCartList.do",true);
		return forward;
	}
	
}