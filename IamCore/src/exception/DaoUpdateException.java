package exception;

public class DaoUpdateException extends Exception {

	
	private static final long serialVersionUID = 1L;
	private Object UpdateFailed;

	/**
	 * @param obj
	 *  * * 	 * <h3>Description</h3>
	 * <p>
	 * This method is used to set the object which has failed to update
	 * </p>
	 */
	public void setUpdateFailed(Object obj) {
		this.UpdateFailed = obj;
	}

	
	@Override
	public String getMessage() {
		return "Problem while updating your account using this details:" + String.valueOf(this.UpdateFailed);
	}
}
