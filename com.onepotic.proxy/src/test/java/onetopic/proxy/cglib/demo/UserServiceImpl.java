package onetopic.proxy.cglib.demo;

/**
 * 目标对象
 * @author yinlg
 * @created 2017年3月2日 下午9:30:42
 */
public class UserServiceImpl{

	/* (non-Javadoc)
	 * @see dynamic.proxy.UserService#add()
	 */
	public void add() {
		System.out.println("--------------------add---------------");
	}
}