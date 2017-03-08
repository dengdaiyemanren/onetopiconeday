package org.com.onetopic.examples.jdk.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableDemo  implements Serializable {
	private static final long serialVersionUID =11122112111L;
	

	transient private Integer age = null;  
	private String name;
	private String gender;
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override 
    public String toString() {  
        return "[" + name + ", " + age + ", " + gender + "]";  
    }  
}
