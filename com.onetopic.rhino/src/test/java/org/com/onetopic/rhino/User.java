package org.com.onetopic.rhino;

public class User {
	
	private int age;
	private String name;
	
	User(String name,int age)
	{
		this.name= name;
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
