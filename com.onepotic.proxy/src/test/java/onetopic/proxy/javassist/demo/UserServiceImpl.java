package onetopic.proxy.javassist.demo;

/**
 * 目标对象
 * @author yinlg
 * @created 2017年3月2日 下午9:30:42
 */
public class UserServiceImpl implements UserService,UserService2{

	/* (non-Javadoc)
	 * @see dynamic.proxy.UserService#add()
	 */
	public void add() {
		System.out.println("--------------------add---------------");
	}

	public void add2() {
		System.out.println("--------------------add2---------------");
		
	}
}