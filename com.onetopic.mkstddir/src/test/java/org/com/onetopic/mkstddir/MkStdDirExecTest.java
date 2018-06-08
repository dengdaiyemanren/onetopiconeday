package org.com.onetopic.mkstddir;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class MkStdDirExecTest {

	private Injector injector;

	public Injector  getInjector() {

		Injector injector = Guice.createInjector(new Module() {
			public void configure(Binder binder) {
				binder.bind(MkStdDirExec.class);
			}
		});
		
		return injector;

	}

	@Before
	public void init() {
		injector = getInjector();
	}

	@Test
	public void readDirInfo() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {
		
		MkStdDirExec intance = injector.getInstance(MkStdDirExec.class);
		
		Field field = intance.getClass().getDeclaredField("lineNoAndLine");
		
		String filePath = this.getClass().getResource("/dirinfo/").getPath() + "dirinfo.txt";
		
		intance.readDirInfo(filePath);
		
		Map<Integer, String> lineNoAndStrs  = new HashMap<Integer, String>();
		
		lineNoAndStrs.put(new Integer(0), "## aa ##");
		lineNoAndStrs.put(new Integer(1), "### bbb ###");
		lineNoAndStrs.put(new Integer(2), "### ccc ###");
		lineNoAndStrs.put(new Integer(3), "#### 111 ####");
		lineNoAndStrs.put(new Integer(4), "## ddd ##");
		lineNoAndStrs.put(new Integer(5), "## ee ##");
		
		Assert.assertEquals(field.get(intance), lineNoAndStrs);
		
		//System.out.println(field.get(intance));
		
	}
	
	@Test
	public void parseLines() throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		MkStdDirExec intance = injector.getInstance(MkStdDirExec.class);
		String filePath = this.getClass().getResource("/dirinfo/").getPath() + "dirinfo.txt";
		
		intance.readDirInfo(filePath);
		intance.parseLines(0, "#", 1, null);
		
		MenuInfo menuInfo = new MenuInfo();
		
		MenuInfo  aa = new MenuInfo();
		aa.setLevel(1);
		aa.setName("aa");
		aa.setParent(menuInfo);
		
		menuInfo.getNexts().add(aa);
		
		MenuInfo bbb = new MenuInfo();
		bbb.setLevel(2);
		bbb.setName("bbb");
		bbb.setParent(aa);
		
		
		MenuInfo ccc = new MenuInfo();
		ccc.setLevel(2);
		ccc.setName("ccc");
		ccc.setParent(aa);
		
		
		MenuInfo eee = new MenuInfo();
		eee.setLevel(3);
		eee.setName("eee");
		eee.setParent(ccc);
		
		

		MenuInfo ddd = new MenuInfo();
		ddd.setLevel(1);
		ddd.setName("ddd");
		ddd.setParent(menuInfo);
		menuInfo.getNexts().add(ddd);
		
		
		
		MenuInfo ee = new MenuInfo();
		ee.setLevel(2);
		ee.setName("ee");
		ee.setParent(aa);
		
		
		Field field = intance.getClass().getDeclaredField("menuInfo");
		
		MenuInfo menuInfo1 = (MenuInfo) field.get(intance);
		//Assert.assertEquals(field.get(intance), menuInfo);
	
		
	}
	
	@Test
	public void mkdir() throws IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		MkStdDirExec intance = injector.getInstance(MkStdDirExec.class);
		String filePath = this.getClass().getResource("/dirinfo/").getPath() + "dirstdinfo.txt";
		
		intance.readDirInfo(filePath);
		intance.parseLines(0, "#", 1, null);
		
		Field field = intance.getClass().getDeclaredField("menuInfo");
		
		MenuInfo menuInfo1 = (MenuInfo) field.get(intance);
		
		intance.mkdir("d:\\", menuInfo1);
		
	}
	
	
	@Test
	public void parseLineContent() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		MkStdDirExec intance = injector.getInstance(MkStdDirExec.class);
		
		//Field field = intance.getClass().getDeclaredField("parseLineContent");
		
		String context = "aaa" ;
		String acutalResult = intance.parseLineContent("#", "# aaa #");
		Assert.assertEquals(acutalResult, context);
	}

}
