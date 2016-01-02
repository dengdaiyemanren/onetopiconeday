package org.com.onetopic.rhino;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.junit.Test;

public class GroovyTest {

	@Test
	public void groovyScript() {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("groovy");

		List<?> orders;
		try {
			//engine.eval(new InputStreamReader(new BufferedInputStream(
			//		new FileInputStream("script/ClientOrder.groovy"))));
			
			String jsFilename = "script/ClientOrder.groovy";
			engine.eval(new FileReader(jsFilename));
			
			//System.out.println(orders.size());
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
