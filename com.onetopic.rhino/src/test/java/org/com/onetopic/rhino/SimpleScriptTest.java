package org.com.onetopic.rhino;

import org.junit.Test;

import java.io.FileReader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;

public class SimpleScriptTest {

	@Test
	public void explainSimpleScript() {
		ScriptEngineManager seManager = new ScriptEngineManager();
		ScriptEngine se = seManager.getEngineByName("js");
		Object ret;
		try {
			ret = se.eval("3+4;");
			System.out.println(ret);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void explainBindScript() {
		ScriptEngineManager seManager = new ScriptEngineManager();
		ScriptEngine se = seManager.getEngineByName("js");
		Bindings bindings = se.createBindings();
		bindings.put("user", new User("张三", 19));

		Object ret;
		try {
			ret = se.eval("print(user.getName()); if(user.age>=18) '已成年'; else '未成年';", bindings);
			System.out.println(ret);

		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void explainExecFunc() {
		ScriptEngineManager seManager = new ScriptEngineManager();
		ScriptEngine se = seManager.getEngineByName("js");
		String script = "function sum(a,b) { return a+b; }";
		try {
			se.eval(script);
			Object ret = se.eval("sum(3,14)");
			System.out.println(ret);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void compileExecFunc() {
		ScriptEngineManager seManager = new ScriptEngineManager();
		ScriptEngine se = seManager.getEngineByName("js");
		Compilable ce = (Compilable) se;
		String script = "function sum(a,b) { return a+b; } sum(a,b);";
		CompiledScript cs;
		try {
			cs = ce.compile(script);
			Bindings bindings = se.createBindings();
			bindings.put("a", 311);
			bindings.put("b", 41);
			Object ret = cs.eval(bindings);
			System.out.println(ret);

		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void compileScript() {
		ScriptEngineManager seManager = new ScriptEngineManager();
		ScriptEngine se = seManager.getEngineByName("js");

		Compilable ce = (Compilable) se;

		String script = "print(user.getName()+'的年龄为'+user.getAge());if(user.age>=18) '已成年'; else '未成年';";

		CompiledScript cs;
		try {
			cs = ce.compile(script);

			Bindings bindings = se.createBindings();
			bindings.put("user", new User("张三", 15));

			Object ret = cs.eval(bindings);
			System.out.println(ret);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void dynamicExecFunc() {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		// JavaScript code in a String
		String script = "function hello(name) { print('Hello, ' + name); }";
		// evaluate script
		try {
			engine.eval(script);
			// javax.script.Invocable is an optional interface.
			// Check whether your script engine implements or not!
			// Note that the JavaScript engine implements Invocable interface.
			Invocable inv = (Invocable) engine;
			// invoke the global function named "hello"
			inv.invokeFunction("hello", "Scripting!!");

		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void dynamicExecMethod() {

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		// JavaScript code in a String. This code defines a script object 'obj'
		// with one method called 'hello'.
		String script = "var obj = new Object(); obj.hello = function(name) { print('Hello, ' + name); }";
		// evaluate script
		try {
			engine.eval(script);
			// javax.script.Invocable is an optional interface.
			// Check whether your script engine implements or not!
			// Note that the JavaScript engine implements Invocable interface.
			Invocable inv = (Invocable) engine;
			// get script object on which we want to call the method
			Object obj = engine.get("obj");
			// invoke the method named "hello" on the script object "obj"
			inv.invokeMethod(obj, "hello", "Script Method111 !!");

		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void dynamicExecJsFile() {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		String jsFilename = "c:\\listFiles.js";
		try {
			engine.eval(new FileReader(jsFilename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
