package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.MemberLoginService;
import vo.ActionForward_member;
import vo.MemberBean;

public class MemberLoginAction implements Action_member{
	 public ActionForward_member execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 
		 
		 	HttpSession session=request.getSession();
	   		MemberBean member=new MemberBean();
	   		
	   		member.setMEMBER_ID(request.getParameter("MEMBER_ID"));
	   		member.setMEMBER_PW(request.getParameter("MEMBER_PW"));
	   		
	   		MemberLoginService memberLoginService = new MemberLoginService();
	   		boolean loginResult = memberLoginService.login(member);
	   		ActionForward_member forward = null;
	   		if(loginResult){
	   	    forward = new ActionForward_member();
	   		session.setAttribute("id", member.getMEMBER_ID());
	   		forward.setRedirect(true);
	   		forward.setPath("./memberListAction.me");
	   		}
	   		else{
	   			response.setContentType("text/html;charset=euc-kr");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('로그인 실패');");
		   		out.println("location.href='./memberLogin.me';");
		   		out.println("</script>");
	   		}
	   		return forward;
	}
}