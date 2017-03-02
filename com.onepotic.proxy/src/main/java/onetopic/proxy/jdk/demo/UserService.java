package onetopic.proxy.jdk.demo;

/**
 * 目标对象实现的接口，用JDK来生成代理对象一定要实现一个接口
 * @author yinlg
 * @created 2017年3月2日 下午9:29:40
 */
public interface UserService {

	/**
	 * 目标方法 
	 */
	public abstract void add();

}