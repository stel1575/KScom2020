package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RamViewService;
import vo.ActionForward;
import vo.Ram;


public class RamViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		RamViewService ramViewService = new RamViewService();
		int id = Integer.parseInt(request.getParameter("id"));
		Ram ram = ramViewService.getRamView(id);
		request.setAttribute("ram", ram);
		Cookie todayImageCookie = new Cookie("today"+id, ram.getImage());
		todayImageCookie.setMaxAge(60*60*24);
		response.addCookie(todayImageCookie);
		ActionForward forward = new ActionForward("ramView.jsp", false);
		return forward;
	}
	
}