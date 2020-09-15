package action;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.RamRegistService;
import vo.ActionForward;
import vo.Ram;




public class RamRegistAction implements Action {
//상품 등록 
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		RamRegistService ramRegistService = new RamRegistService();
		String realFolder = "";
		
		
		String saveFolder = "/images"; //경로
		String encType = "UTF-8";
		int maxSize = 10*1024*1024; //10mb 까지 업로드가능
		
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request,
					realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image");

		Ram ram = new Ram(0, multi.getParameter("brand"),
				multi.getParameter("name"),
				multi.getParameter("clock"),
				multi.getParameter("capacity"),
				image, 
				Integer.parseInt(multi.getParameter("price")),
				multi.getParameter("content"),
				0);
		
		boolean isRegistSuccess = ramRegistService.registRam(ram);
		ActionForward forward = null;
		
		if(isRegistSuccess){
			
			forward = new ActionForward("ramList.do", true);
			
			
		}else if(!isRegistSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
