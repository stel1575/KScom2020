package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward_member;

public interface Action_member {
	public ActionForward_member execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
	}
