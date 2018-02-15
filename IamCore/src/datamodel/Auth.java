package datamodel;

public class Auth {
	
	private String password;
	private int identityId;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdentityId() {
		return identityId;
	}
	public void setIdentityId(int identityId) {
		this.identityId = identityId;
	}
	@Override
	public String toString() {
		return "Auth [password=" + password + ", identityId=" + identityId + "]";
	}
	

}
