package issuetracking;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TicketFeature extends Ticket { 

	private String estimated_time;

	public TicketFeature(int id, int sprintid, String title,
			String description, Date date, String author,
			String responsible_user, String type, String state,
			String estimated_time) {
		super(id, sprintid, title, description, date, author, responsible_user,
				type, state);
		this.estimated_time = estimated_time;
	}
//	public TicketFeature() {
//	}
	
	

	public String getEstimated_time() {
		return estimated_time;
	}

	public void setEstimated_time(String estimated_time) {
		this.estimated_time = estimated_time;
	}

	public Map<String, String> validate() {
		Map<String, String> errorMsg = new HashMap<String, String>();
		if (title == null || title.trim().equals(""))
			errorMsg.put("title", "This field should not be empty!");
		if (description == null || description.trim().equals(""))
			errorMsg.put("description", "This field should not be empty!");
		if (author == null || author.trim().equals(""))
			errorMsg.put("author", "This field should not be empty!");
		if (!DBManager1.containsUser(author))
			errorMsg.put("author", "The user does not exist!");
		if (responsible_user == null || responsible_user.trim().equals(""))
			errorMsg.put("responsible_user",
					"This field should not be empty!");
		if (!DBManager1.containsUser(responsible_user))
			errorMsg.put("responsible_user", "The user does not exist!");
		if (type == null || type.trim().equals(""))
			errorMsg.put("type", "This field should not be empty!!");
		if (state == null || state.trim().equals(""))
			errorMsg.put("state", "This field should not be empty!!");
		if (estimated_time == null || estimated_time.trim().equals(""))
			errorMsg.put("estimated_time",
					"estimated_time darf nicht leer sein!");

		return errorMsg;
	}
}
