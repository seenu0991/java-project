package exception;


public class DaoCreateException extends Exception {


	private static final long serialVersionUID = 1L;
private Object faultObject;
	
	/**
	 * @param obj
	 *  * * 	 * <h3>Description</h3>
	 * <p>
	 * This method sets the object which has the fault and return is done later
	 * </p>
	 */
	public void setFaultObject(Object obj){
		this.faultObject = obj;
	}

	
	@Override
	public String getMessage() {
		return "Problem while creating:" + String.valueOf(this.faultObject);
	}
	
}

