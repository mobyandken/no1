package cn.itcast.exception;

public class CustomException extends Exception{

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public CustomException(String msg) {
		super();
		this.msg = msg;
	}

	public CustomException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
