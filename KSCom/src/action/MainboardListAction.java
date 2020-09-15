package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MainboardListService;
import vo.ActionForward;
import vo.Mainboard;



public class MainboardListAction implements Action {

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
		MainboardListService mainboardListService = new MainboardListService();
		ArrayList<Mainboard> mainboardList = MainboardListService.getMainboardList();
		request.setAttribute("mainboardList", mainboardList);
		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward("mainboardList.jsp", false);
		
		return forward;
		
		
	}

}
