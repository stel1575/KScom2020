package action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.MemberListService;
import vo.ActionForward_member;
import vo.MemberBean;

public class MemberListAction implements Action_member{
	 public ActionForward_member execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	HttpSession session=request.getSession();
	   		String id=(String)session.getAttribute("id");
	   		ActionForward_member forward = null;
	   		if(id==null){
	   			forward = new ActionForward_member();
				forward.setRedirect(true);
				forward.setPath("./memberLogin.me");
	   		}else if(!id.equals("admin")){
	   			response.setContentType("text/html;charset=UTF-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('관리자가 아닙니다.');");
		   		out.println("location.href='./memberLogin.me");
		   		out.println("</script>");
	   		}
	   		else{
	   	    forward = new ActionForward_member();
	   	    MemberListService memberListService = new MemberListService();
	   		ArrayList<MemberBean> memberList=memberListService.getMemberList();
	   		request.setAttribute("memberList", memberList);
	   		forward.setPath("./member_list.jsp");
	   		}
	   		return forward;
	}
}