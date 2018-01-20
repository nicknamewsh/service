package com.pt.ssm.util;

public class ModelResults {
	
	private Long start; 
	private Long end; 
	private Long total; 
	private Object rows;


	public ModelResults(long start, long end) {
		this.start = start;
		this.end = end;
		setStart(start);
		setEnd(end);
	}
	
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start+1;
			
	}
	public Long getEnd() {
		return end;
	}
	public void setEnd(Long end) {
		this.end = this.start + this.end-1;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}
	

}
