package action;

import issuetracking.*;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeCommentAction implements Action {
		
		private static final DBManager DBManager1 = DBManager.getInstance();

		@Override
		public String execute(HttpServletRequest request,
				HttpServletResponse response) {
			Comment comment1 = DBManager1.getCommentById(Integer.parseInt(request.getParameter("comment_id")));
			Map<String, String> errorMsgs = new HashMap<String, String>();
			
			Comment comment2 = new Comment(comment1.getCid(),comment1.getTid(),comment1.getCreation_date(),comment1.getAuthor(),request.getParameter("message"));
			
			errorMsgs = comment2.validate();
			if(errorMsgs.isEmpty()){
				DBManager1.updateComment(comment2);
			}
			
			request.setAttribute("errorMsgs", errorMsgs);
			return "user/commentview.jsp";
		}

	}
