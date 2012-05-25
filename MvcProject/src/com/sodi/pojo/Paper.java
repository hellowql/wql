package com.sodi.pojo;

import java.io.Serializable;

public class Paper implements Serializable{
	private int paperId;
	private String paperTitle;
	private String description;
	public Paper(){}
	public void setPaperId(int paperId)
	{
		this.paperId=paperId;
	}
	public String getPaperTitle() {
		return paperTitle;
	}
	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPaperId()
	{
		return this.paperId;
	}

}
