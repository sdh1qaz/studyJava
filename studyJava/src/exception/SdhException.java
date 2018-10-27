package exception;
/**
 * <p>统一异常基础类</p>
 * @author Administrator
 *
 */
public class SdhException extends Exception{

	/**
	 * 
	 */
	private final static  long serialVersionUID = 1L;
	
	private String errorCode;//异常编码
	
	public SdhException(String errorCode){
		super(errorCode);
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}




}
