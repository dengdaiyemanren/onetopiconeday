package org.com.onetopic.mkstddir;

import java.util.ArrayList;
import java.util.List;

public class MenuInfo {
	
	List<MenuInfo> nexts = new ArrayList();
	
	MenuInfo parent ;
	
	
	String name;
	
	int level;
	
	
	public List<MenuInfo> getNexts() {
		return nexts;
	}

	public void addNext( MenuInfo next) {
		nexts.add(next);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public MenuInfo getParent() {
		return parent;
	}

	public void setParent(MenuInfo parent) {
		this.parent = parent;
	}

	public void setNexts(List<MenuInfo> nexts) {
		this.nexts = nexts;
	}
	
	

	

}
