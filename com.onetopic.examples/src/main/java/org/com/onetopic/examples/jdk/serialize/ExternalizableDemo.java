package org.com.onetopic.examples.jdk.serialize;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableDemo  implements Externalizable {

	transient private Integer age = null;  
	private String name;
	private String gender;
	
	public void writeExternal(ObjectOutput out) throws IOException {
		
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		
	}
	
	 private void writeObject(ObjectOutputStream out) throws IOException {  
	        out.defaultWriteObject();  
	        out.writeInt(age);  
	    } 
	 private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {  
	        in.defaultReadObject();  
	        age = in.readInt();  
	    }  
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
		
		
		@Override 
	    public String toString() {  
	        return "[" + name + ", " + age + ", " + gender + "]";  
	    }  
}
