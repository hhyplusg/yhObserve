package com.wave.base.action;



public class BaseClientDatatModel<T> {
    // code：0：成功，1：失败，其他值待定。
    private int code;

    private String msg;

    private T data;
    
	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BaseClientDatatModel [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	private void init(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseClientDatatModel() {
        init(0, null, null);
    }

    public BaseClientDatatModel(int code, String msg, T data) {
        init(code, msg, data);
    }

    public BaseClientDatatModel(int code) {
        init(code, null, null);
    }

    public BaseClientDatatModel(int code, String msg) {
        init(code, msg, null);
    }

    public BaseClientDatatModel(String msg) {
        init(0, msg, null);
    }

    public BaseClientDatatModel(String msg, T data) {
        init(0, msg, data);
    }

    public BaseClientDatatModel(T data) {
        init(0, null, data);
    }
}
