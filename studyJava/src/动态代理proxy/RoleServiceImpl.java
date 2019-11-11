package 动态代理proxy;
/**
 * @ClassName： RoleServiceImpl
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年11月21日
 */

public class RoleServiceImpl implements RoleService{
	
	public void printRole(Role role) {
		System.out.println(role.toString());
	}

}
