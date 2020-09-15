package action;

import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.CpuListService;

import vo.ActionForward;
import vo.Cpu;

public class CpuListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<String> todayImageList = new ArrayList<String>();
		Cookie[] cookieArray = request.getCookies();
		
		if(cookieArray != null){
			for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")){
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		
		CpuListService cpuListService = new CpuListService();
		ArrayList<Cpu> cpuList = cpuListService.getCpuList();
		request.setAttribute("cpuList", cpuList);
		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward("cpuList.jsp", false);
		
		return forward;
	}
	
}
