package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.MemberViewService;
import vo.ActionForward_member;
import vo.MemberBean;

public class MemberViewAction implements Action_member{
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
	   			response.setContentType("text/html;charset=euc-kr");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('�����ڰ� �ƴմϴ�.');");
		   		out.println("location.href='./memberLogin.me';");
		   		out.println("</script>");
	   		}
	   		
	   		else{
	   		forward = new ActionForward_member();
	   		String viewId=request.getParameter("id");
	   		MemberViewService memberViewService = new MemberViewService();
	   		MemberBean member=memberViewService.getMember(viewId);
	   		request.setAttribute("member", member);
	   		forward.setPath("./member_info.jsp");
	   		}
	   		return forward;
	}
}