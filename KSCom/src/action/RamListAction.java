package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RamListService;
import vo.ActionForward;
import vo.Ram;


public class RamListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> todayImageList = new ArrayList<String>();
		Cookie[] cookieArray = request.getCookies();
		
		if(cookieArray != null){
			for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().startsWith("today")){
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		RamListService ramListService = new RamListService();
		ArrayList<Ram> ramList = ramListService.getRamList();
		request.setAttribute("ramList", ramList);
		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward("ramList.jsp", false);
		
		return forward;
		
		
	}

}
