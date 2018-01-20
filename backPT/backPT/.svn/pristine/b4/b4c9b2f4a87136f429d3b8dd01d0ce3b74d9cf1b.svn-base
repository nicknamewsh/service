package com.pt.ssm.po;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;


public class Tree implements Serializable{
	private static final long serialVersionUID = 7801108216512223194L;
	
	private String text;
	private boolean selectable = false;
	private List<Tree> nodes;
	private String id;
	private String pid;
	public List<Tree> getNodes() {
		return nodes;
	}
	public void setNodes(List<Tree> nodes) {
		this.nodes = nodes;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isSelectable() {
		return selectable;
	}
	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Tree [text=" + text + ", selectable=" + selectable + ", nodes="
				+ nodes + ", id=" + id + ", pid=" + pid + "]";
	}
	
	
	
}
