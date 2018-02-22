package datamodel;

public class Identity {

	
	
	/**
	 * @return uid
	 *  * * 	 * <h3>Description</h3>
	 * <p>
	 * This method is used to get the uid stored in this identity
	 * </p>
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid
	 *  * * 	 * <h3>Description</h3>
	 * <p>
	 * This method is used to set the uid value in this identity
	 * </p>
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return display_name
	 *  * * 	 * <h3>Description</h3>
	 * <p>
	 * This method is used to get the display_name stored in this identity
	 * </p>
	 */
	public String getDisplay_name() {
		return display_name;
	}
	/**
	 * @param display_name
	 *  * * 	 * <h3>Description</h3>
	 * <p>
	 * This method is used to set the display name in this identity
	 * </p>
	 */
	/**
	 * @param display_name
	 * 
	 */
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	/**
	 * @return email_id
	 *  * * 	 * <h3>Description</h3>
	 * <p>
	 * This method is used to get the email id from this identity
	 * </p>
	 */
	public String getEmail_id() {
		return email_id;
	}
	/**
	 * @param email_id
	 *  * * 	 * <h3>Description</h3>
	 * <p>
	 * This method is used to set the email id in this identity
	 * </p>
	 
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	private String uid;
	
	@Override
	public String toString() {
		return "display_name=" + display_name + " \nEmail_id=" + email_id + "\nUser Id=" + uid + "";
	}
	private String display_name;
	private String email_id;
	private String password;
	
	/**
	 * @return password
	 * 	 * <h3>Description</h3>
	 * <p>
	 * This method is used to get the password of the current identity
	 * </p>
	 * 
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 * * 	 * <h3>Description</h3>
	 * <p>
	 * This method is used to set the password in this identity
	 * </p>
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
}
