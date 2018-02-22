package exception;

public class DaoDeleteException extends Exception{


	private static final long serialVersionUID = 1L;
private Object DeleteFailed;
	
	/**
	 * @param obj
	 *  * * 	 * <h3>Description</h3>
	 * <p>
	 * This method is used to set the object which has failed to delete to the Object created called Deletefailed
	 * </p>
	 */
	public void setUpdateFailed(Object obj){
		this.DeleteFailed = obj;
	}

	
	@Override
	public String getMessage() {
		return "Problem while updating your account using this details:" + String.valueOf(this.DeleteFailed);
	}
	
}
