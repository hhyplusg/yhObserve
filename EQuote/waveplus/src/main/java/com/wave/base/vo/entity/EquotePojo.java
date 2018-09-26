package com.wave.base.vo.entity;

public class EquotePojo extends Equote {

	public EquotePojo(String[] ids) {
		super();
		this.ids = ids;
	}

	public EquotePojo() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String []ids;

	public String[] getIds() {
		return ids;
	}

	public void setIds(String []ids) {
		this.ids = ids;
	}
	
}