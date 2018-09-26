package com.wave.base.action;

public class ClientDatatModel<T> {
    // code：0：失败，1：成功，其他值待定。
    private int code;

    private String msg;

    private T data;
    
    private int totalResultsCount;
    
    private int pagesize = 10; //每页显示记录数 
    
    private int pagenum;	//当前页
    @Override
    public String toString() {
        return "ClientDatatModel [code=" + code + ", msg=" + msg + ", data=" + data + ", totalResultsCount=" + totalResultsCount + ", pagesize=" + pagesize + ", pagenum=" + pagenum + "]";
    }

	public int getPagesize() {
		return pagesize;
	}

    public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	public int getTotalResultsCount() {
		return totalResultsCount;
	}

	public void setTotalResultsCount(int totalResultsCount) {
		this.totalResultsCount = totalResultsCount;
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

    public ClientDatatModel() {
        init(1, null, null);
    }

    public ClientDatatModel(int code, String msg, T data) {
        init(code, msg, data);
    }

    public ClientDatatModel(int code) {
        init(code, null, null);
    }

    public ClientDatatModel(int code, String msg) {
        init(code, msg, null);
    }

    public ClientDatatModel(String msg) {
        init(1, msg, null);
    }

    public ClientDatatModel(String msg, T data) {
        init(1, msg, data);
    }

    public ClientDatatModel(T data) {
        init(1, null, data);
    }
}
