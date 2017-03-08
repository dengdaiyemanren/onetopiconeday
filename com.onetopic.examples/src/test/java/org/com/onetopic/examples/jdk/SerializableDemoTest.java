package org.com.onetopic.examples.jdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.com.onetopic.examples.jdk.serialize.ExternalizableDemo;
import org.com.onetopic.examples.jdk.serialize.ExternalizableDemo2;
import org.com.onetopic.examples.jdk.serialize.SerializableDemo;
import org.com.onetopic.examples.jdk.serialize.SerializableDemo2;
import org.junit.Test;

import junit.framework.Assert;

public class SerializableDemoTest {
	@Test
	public void noSerializablePrint() {
		SerializableDemo demo = new SerializableDemo();
		demo.setAge(11);
		demo.setName("name");
		demo.setGender("gender");
		Assert.assertEquals("[name, 11, gender]", demo.toString());
	}

	@Test
	public void serializablePrint() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = null;
		try {

			file = new File("person.out");

			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
			SerializableDemo person = new SerializableDemo();

			person.setAge(11);
			person.setName("name");
			person.setGender("gender");

			oout.writeObject(person);
			oout.close();

			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
			Object newPerson = oin.readObject(); // 没有强制转换到Person类型
			oin.close();

			Assert.assertEquals("[name, null, gender]", newPerson.toString());

		} finally {

			file.delete();
		}

	}

	@Test
	public void serializableAnotherPrint() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = null;
		try {

			file = new File("person.out");

			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
			SerializableDemo2 person = new SerializableDemo2();

			person.setAge(11);
			person.setName("name");
			person.setGender("gender");

			oout.writeObject(person);
			oout.close();

			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
			Object newPerson = oin.readObject(); // 没有强制转换到Person类型
			oin.close();

			Assert.assertEquals("[name, 11, gender]", newPerson.toString());

		} finally {

			file.delete();
		}

	}

	@Test
	public void externalizablePrint() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = null;
		try {

			file = new File("person.out");

			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
			ExternalizableDemo person = new ExternalizableDemo();

			person.setAge(11);
			person.setName("name");
			person.setGender("gender");

			oout.writeObject(person);
			oout.close();

			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
			Object newPerson = oin.readObject(); // 没有强制转换到Person类型
			oin.close();

			Assert.assertEquals("[null, null, null]", newPerson.toString());

		} finally {

			file.delete();
		}

	}

	@Test
	public void externalizablePrint2() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = null;
		try {

			file = new File("person.out");

			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
			ExternalizableDemo2 person = new ExternalizableDemo2();

			person.setAge(11);
			person.setName("name");
			person.setGender("gender");

			oout.writeObject(person);
			oout.close();

			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
			Object newPerson = oin.readObject(); // 没有强制转换到Person类型
			oin.close();

			Assert.assertEquals("[name, 11, gender]", newPerson.toString());

		} finally {

			file.delete();
		}

	}
}
