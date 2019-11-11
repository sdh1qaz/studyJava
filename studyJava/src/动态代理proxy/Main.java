package 动态代理proxy;
/**
 * @ClassName： Main
 * @Author: dhSu
 * @Description:
 * @Date:Created in 2018年11月21日
 */

public class Main {
	public static void main(String[] args) {
		RoleService roleService = new RoleServiceImpl();
		Interceptor interceptor = new RoleInterceptor();
		
		RoleService proxy = (RoleService)ProxyBeanUtil.getBean(roleService, interceptor);
		Role role = new Role(1L,"role_name_1","role_note_1");
		proxy.printRole(role);
		
		System.out.println("######################################测试afterThrowing方法#####################");
		role = null;
		proxy.printRole(role);
	}
}
