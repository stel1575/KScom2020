package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;

public class CpuRegistFormAction implements Action {
//상품 등록한 페이지 보여주는 액션
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward("cpuRegistForm.jsp", false);
		return forward;
	}
	
}