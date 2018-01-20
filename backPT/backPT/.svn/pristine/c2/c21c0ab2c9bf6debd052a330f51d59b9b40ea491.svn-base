package com.pt.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pt.ssm.dao.MenuDao;
import com.pt.ssm.po.Menu;
import com.pt.ssm.service.MenuService;
import com.pt.ssm.util.ModelBean;



@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	
	private List<Menu> menuList = new ArrayList<Menu>();

	@Override
	public ModelBean getMenuList(String roleId) {
		
		ModelBean bean = new ModelBean();
		menuList.clear();
		try {
			//根据roleId查询所有的Menu
			List<Menu> list = menuDao.getMenuList(roleId);
			//根据roleId查询所有的button
			List<Menu> buttonList = menuDao.getButtonList(roleId);
			
			
			//循环得到有用的属性值  存入menuList中
			for (int i = 0; i < list.size(); i++) {
				Menu menu = new Menu();
				menu.setMenuId(list.get(i).getMenuId());
				menu.setMenuName(list.get(i).getMenuName());
				menu.setPid(list.get(i).getPid());
				menu.setUrl(list.get(i).getUrl());
				menu.setMenuStyle(list.get(i).getMenuStyle());
				menuList.add(menu);
			}
			//menuList2  是将menuList中的所有菜单按照父子级来重组的集合
			List<Menu> menuList2 = serchAllMenu();
			StringBuffer sb = new StringBuffer().append("[");
			String msg = toJsonString(sb, menuList2);
			String json = msg + "]";
			bean.setObj(json);
			bean.setData(buttonList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;

	}

	private String toJsonString(StringBuffer sb, List<Menu> menuList2) {
		if(menuList2.size()>0){
			for (int i = 0; i < menuList2.size(); i++) {
				Menu menu = menuList2.get(i);
				if (menu.getChildMenu() != null) {
					sb.append("{\"name\":").append("\"").append(menu.getMenuName())
							.append("\",\"id\":\"").append(menu.getMenuId())
							.append("\",\"parentid\":\"").append(menu.getPid());
					if(menu.getUrl() != null && menu.getUrl() != "" && menu.getUrl() !="null"){
						sb.append("\",\"url\":\"").append(menu.getUrl());
					}
					if(menu.getMenuStyle() != null && menu.getMenuStyle() != "" && menu.getMenuStyle() !="null"){
						sb.append("\",\"style\":\"").append(menu.getMenuStyle());
					}
					//,\"open\":\"true\"
					sb.append("\"");
					sb.append(",\"children\":[");
					toJsonString(sb, menu.getChildMenu());
					sb.deleteCharAt(sb.toString().length() - 1);
					sb.append("]},");
				} else {
					sb.append("{\"name\":\"").append(menu.getMenuName())
							.append("\",\"id\":\"").append(menu.getMenuId())
							.append("\",\"parentid\":\"").append(menu.getPid());
					if(menu.getUrl() != null && menu.getUrl() != "" && menu.getUrl() !="null"){
						sb.append("\",\"url\":\"").append(menu.getUrl());
					}
					if(menu.getMenuStyle() != null && menu.getMenuStyle() != "" && menu.getMenuStyle() !="null"){
						sb.append("\",\"style\":\"").append(menu.getMenuStyle());
					}
					sb.append("\"");
					sb.append("},");
				}
			}
			return sb.toString().substring(0, sb.toString().length() - 1);
		}else{
			return sb.toString();
		}
	}

	private List<Menu> serchAllMenu() {
		//全部的菜单，menuList
		List<Menu> listAllObject = new ArrayList<Menu>();
		//新的菜单，拥有子菜单的菜单
		List<Menu> listAllMenu = new ArrayList<Menu>();
		//中间集合，一个桥梁
		List<Object[]> tmp = new ArrayList<Object[]>();
		listAllObject = menuList;
		for (Menu menu : listAllObject) {
			Object[] ro = new Object[5];
			ro[0] = menu.getMenuId();
			ro[1] = menu.getMenuName();
			ro[2] = menu.getPid();
			ro[3] = menu.getUrl();
			ro[4] = menu.getMenuStyle();
			tmp.add(ro);
		}
		for (Object[] row : tmp) {
			if (row[2].toString().equals("0")) {
				Menu me = new Menu();
				me.setMenuId((Integer) row[0]);
				me.setMenuName(String.valueOf(row[1]));
				me.setPid((Integer) row[2]);
				me.setUrl(String.valueOf(row[3]));
				me.setMenuStyle(String.valueOf(row[4]));
				listAllMenu.add(me);
				fomateMenu(tmp, me);
			}
		}
		return listAllMenu;
	}

	private void fomateMenu(List<Object[]> tmp, Menu menu) {
		for (Object[] row : tmp) {
			if (row[2] != null
					&& Integer.parseInt(String.valueOf(row[2])) == menu
							.getMenuId()) {
				Menu m = new Menu();
				m.setMenuId((Integer) row[0]);
				m.setMenuName(String.valueOf(row[1]));
				m.setPid((Integer) row[2]);
				m.setUrl(String.valueOf(row[3]));
				m.setMenuStyle(String.valueOf(row[4]));
				List<Menu> list = menu.getChildMenu();
				if (list == null) {
					list = new ArrayList<Menu>();
				}
				list.add(m);
				menu.setChildMenu(list);
				fomateMenu(tmp, m);
			}
		}
	}

}
