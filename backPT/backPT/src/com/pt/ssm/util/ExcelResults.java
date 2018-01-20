package com.pt.ssm.util;

import org.apache.poi.ss.usermodel.Sheet;

/**
 * 
 * @author LL
 *
 */
public class ExcelResults {
	
	private int totalRows;
	private int totalCells;
	private Sheet sheet;
	private String errorMsg;
	
	public ExcelResults(){
		
	}
	
	public ExcelResults(int totalRows,int totalCells,Sheet sheet){
		this.totalRows = totalRows;
		this.totalCells = totalCells;
		this.sheet = sheet;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalCells() {
		return totalCells;
	}

	public void setTotalCells(int totalCells) {
		this.totalCells = totalCells;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	} 
	
	
	
}
