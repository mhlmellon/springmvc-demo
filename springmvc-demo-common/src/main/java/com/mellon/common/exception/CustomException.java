package com.mellon.common.exception;


public class CustomException extends UnsupportedOperationException {

	private static final long serialVersionUID = 1L;
	
	private String code;

	public CustomException() {
	}

	public CustomException(String message) {
		super(message);
	}
	
	public CustomException(String message, String code) {
		super(message);
		this.setCode(code);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomException(Throwable cause) {
		super(cause);
	}
	
	public synchronized Throwable getCause() {
        return this;
    }
	
	public synchronized Throwable initCause(Throwable cause) {
			return this;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
