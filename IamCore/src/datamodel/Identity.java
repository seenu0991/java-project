package datamodel;

public class Identity {

	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	private String uid;
	@Override
	public String toString() {
		return "Identity [uid=" + uid + ", display_name=" + display_name + ", email_id=" + email_id + "]";
	}
	private String display_name;
	private String email_id;
	
}
