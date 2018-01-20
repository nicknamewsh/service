package com.pt.ssm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.pt.ssm.po.Tree;


public class BuildTree {
	/**
	 * 建造前端树的数据类型
	 * @param List<Map<String,Object>> data
	 * */
	public static final Tree buildTree(List<Map<String,Object>> data){
		List<Tree>  parentnodes = new ArrayList<Tree>();
		Tree root = new Tree();
		 
		
		try{
			root.setId("-1");
			root.setPid("-1"); 
			root.setText("根目录"); 
			root.setSelectable(false);
			root.setNodes( new ArrayList<Tree>() );
			
			Tree node;
			//转小写
			List<Map<String, Object>>  listtmp = BuildTree.setListkeyTolowercase(data);
	        for (int i = 0, j = listtmp.size(); i < j; i++) {

	        	Map<String, Object> info = listtmp.get(i);
	   
	            //node为tree用到的json数据
	        	node = new Tree();
	        	node.setId(info.get("menuid").toString());
	        	node.setSelectable(info.get("isleaf").equals("0") ? false : false);
	        	node.setPid(info.get("pid").toString());
	        	node.setText(info.get("menuname").toString());
	        	node.setNodes( new ArrayList<Tree>() );
	        	
 		        	
	            if (info.get("pid").toString().equals("0") ) { 
	                parentnodes.add(node);
	                root.getNodes().add(node);
	            } else {
	                getChildrenNodes(parentnodes, node);
	                parentnodes.add(node);
	            }
	        }
        
		}catch(Exception e ){
			System.out.println("buildLayerList:"+e.toString());
		}
		JSONObject json=new JSONObject();
		
      System.out.println(root);
	return root;
	}



	/**
	 * 将key值转成小写
	 * 
	 * @return
	 */
	public static List<Map<String, Object>> setListkeyTolowercase(
			List<Map<String, Object>> l) {

		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>(
				l.size());

		for (Map<String, Object> m : l) {
			Map<String, Object> map = new HashMap<String, Object>(m.size());
			for (String k : m.keySet()) {
				if (k.equals("_parentId")) {
					map.put(k, m.get(k));
				} else {
					map.put(k.toLowerCase(), m.get(k));
				}
			}
			returnList.add(map);

		}

		return returnList;
	}



	public static void getChildrenNodes(List<Tree>  parentnodes, Tree node) {
	    for (int i = parentnodes.size() - 1; i >= 0; i--) {

	    	Tree pnode = parentnodes.get(i);
	        //如果是父子关系，为父节点增加子节点，退出for循环
	        if (pnode.getId() .equals( node.getPid())) {
	            pnode.setSelectable(false); //关闭二级树
	            //pnode.children.add(node);
	            pnode.getNodes().add(node);
	            return;
	        } else {
	            //如果不是父子关系，删除父节点栈里当前的节点，
	            //继续此次循环，直到确定父子关系或不存在退出for循环
	            parentnodes.remove(node);
	        }
	    }
	}




}
