package PrepeardStatment;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		testAdd();
		testUpdate();
		testDelete();
		testfinByLogin();
		testfinByPk();
		testAuthenticate();
		testSearch();
}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("Suraj");
		bean.setFirstName("Sahu");
		bean.setlogin("suraj@gmail.com");
		bean.setPassward("suraj123");
		bean.setdob(sdf.parse("2006-11-07"));

		model.add(bean);

	}

	public static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(5);
		bean.setFirstName("Suman");
		bean.setFirstName("Sahu");
		bean.setlogin("suraj@gmail.com");
		bean.setPassward("suraj123");
		bean.setdob(sdf.parse("2006-11-07"));

		model.update(bean);

	}

	public static void testDelete() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(5);

		model.delete(bean);

	}

	public static void testfinByLogin() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByLogin("ram123@gmail.com");

		if (bean == null) {
			System.out.println("user not found");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getlogin());
			System.out.println(bean.getPassward());
			System.out.println(bean.getdob());
		}

	}

	public static void testfinByPk() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByPk(7);

		if (bean == null) {
			System.out.println("user not found");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getlogin());
			System.out.println(bean.getPassward());
			System.out.println(bean.getdob());
		}

	}

	public static void testAuthenticate() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.authenticate("ram@gmail.com", "ram123");

		if (bean == null) {
			System.out.println("invalid login and password");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getlogin());
			System.out.println(bean.getPassward());
			System.out.println(bean.getdob());
		}

	}

	public static void testSearch() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("s");
		// bean.setLastName("Verma");

		List list = model.search(bean);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getlogin());
			System.out.println(bean.getPassward());
			System.out.println(bean.getdob());
			System.out.println("--------------");
		}

	}
	
}
