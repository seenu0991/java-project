package logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <h3>Description</h3>
 * <p>
 * This class allows to create a logger and then it is used to perform the logging of the operations in the program
 * </p>
 *
 * <h3>Usage</h3>
 * <p>
 * This class should be used as follows:
 *
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * 
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class Logger {

	
	private static final String logPath = "log/application.log";
	private static PrintWriter pw;

	private static final String ERROR = "ERROR";
	private static final String INFO = "INFO";

	static {
		try {
			pw = new PrintWriter(new FileOutputStream(new File(logPath), true));
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private final Class<?> cls;

	public Logger(Class<?> cls) {
		this.cls = cls;

	}

	public void error(String message) {
		printMessage(message, ERROR);
	}

	public void info(String message) {
		printMessage(message, INFO);
	}

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This methods allows to write the message to the file as a log and then it can be used to check 
	 * who has logged in at what time
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows : 
	 * In this method the arguements are passed as string message and the String level 
	 * and then the complete message is printed using the print writer and write it to the file
	 * </p>
	 * @author abdul
	 *	 */
	private void printMessage(String message, String Level) {
		final String completeMessage = getTimeStamp() + " - " + Level + " - " + cls.getCanonicalName() + " " + message;
		pw.println(completeMessage);
		pw.flush();
	}

	private static String getTimeStamp() {
		final Date date = new Date();

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
		return sdf.format(date);
	}

	/**
	 * <h3>Description</h3>
	 * <p>
	 * This methods allows to print the error message in the console
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 * first, the value is set in the message by passing arguements and then using print it is printed
	 * 
	 * </p>
	 * 
	 * @since $${version}
	 * @author abdul,simbu
	 *
	 */
	public void error(String message, Exception e) {
		printMessage(message, ERROR);
		e.printStackTrace(pw);
		pw.flush();
	}

}
