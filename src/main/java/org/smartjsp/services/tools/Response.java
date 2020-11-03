package org.smartjsp.services.tools;

public class Response {
	private String title;
	private String message;
	
	public Response(String message){
		title =  "SMJ Service Response";
		this.message=message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
