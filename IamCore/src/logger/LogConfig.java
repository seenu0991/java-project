package logger;

public class LogConfig {

	private String filePath;

	/**
	 * @return the filePath
	 * *  *  * * 	 * <h3>Description</h3>
	 * <p>
	 * The filepath is returned from here
	 * </p>
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath
	 * * *  *  * * 	 * <h3>Description</h3>
	 * <p>
	 * the filePath is set so that it can be get later
	 * </p>
	
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @param filePath
	 * 
	 *  * <h3>Description</h3>
	 * <p>
	 * this method is used to set the filepath passed as arguement and set it to filepath of this class
	 * </p>
	 */
	public LogConfig(String filePath) {
		this.filePath = filePath;
	}

}
