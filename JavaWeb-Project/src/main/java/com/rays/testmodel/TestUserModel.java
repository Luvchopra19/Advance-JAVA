package com.rays.testmodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;


public class TestUserModel {
	
		public static void main(String[] args) throws Exception {
			testAdd();
//			testUpdate();
//			testdelet();
	//testfindByLogin();
//			testfindByPk();
//			testAuthenticate();
		//testSearch();
		}
			private static void testSearch() throws Exception {

				UserModel model = new UserModel();
				UserBean bean = new UserBean();
				
				bean.setFirstName("P");
				bean.setLastName("Birla");
				
				List list = model.search(bean, 0, 0);
				
				Iterator<UserBean> it = list.iterator();
				
				while (it.hasNext()) {
					bean = it.next();
					System.out.println(bean.getId());
					System.out.println(bean.getFirstName());
					System.out.println(bean.getLastName());
					System.out.println(bean.getLogin());
					System.out.println(bean.getPassword());
					System.out.println(bean.getDob());
					System.out.println("--------------");
				}
		}
			private static void testAuthenticate() throws Exception {
			
				UserModel model = new UserModel();
				UserBean bean = new UserBean();
				
				bean = model.authenticate("himanshu@gmail.com", "himanshu@123");
				
				if(bean == null) {
					System.out.println("User Not Found");
				}else {
					System.out.println(bean.getId());
					System.out.println(bean.getFirstName());
					System.out.println(bean.getLastName());
					System.out.println(bean.getLogin());
					System.out.println(bean.getPassword());
					System.out.println(bean.getDob());
				}
			
		}
			private static void testfindByPk() throws Exception {
			 

				UserModel model = new UserModel();
				UserBean bean = new UserBean();
				
				bean = model.findByPk(2);
				
				if(bean == null) {
					System.out.println("User Not Found");
				}else {
					System.out.println(bean.getId());
					System.out.println(bean.getFirstName());
					System.out.println(bean.getLastName());
					System.out.println(bean.getLogin());
					System.out.println(bean.getPassword());
					System.out.println(bean.getDob());
				}
				
		}
			private static void testfindByLogin() throws Exception {
			
				UserModel model = new UserModel();
				UserBean bean = new UserBean();
				
				bean = model.findByLogin("luvchopra12@gmail.com");
				
				if(bean == null) {
					System.out.println("User Not Found");
				}else {
					System.out.println(bean.getId());
					System.out.println(bean.getFirstName());
					System.out.println(bean.getLastName());
					System.out.println(bean.getLogin());
					System.out.println(bean.getPassword());
					System.out.println(bean.getDob());
				}
			
		}
			private static void testdelet() throws Exception {
			
				UserModel model = new UserModel();
				UserBean bean = new UserBean();
				
				bean.setId(6);
				model.delete(bean);
			
		}
			private static void testUpdate() throws Exception {
			
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				
				UserModel model = new UserModel();
				UserBean bean = new UserBean();
				
		
				bean.setId(5);
				bean.setFirstName("Naren");
				bean.setLastName("Patel");
				bean.setLogin("naren@gmail.com");
				bean.setPassword("Naren@123");
				bean.setDob(sdf.parse("2004-10-03"));
				
				model.update(bean);
		}
			public static void testAdd() throws Exception {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				UserModel model = new UserModel();
				UserBean bean = new UserBean();

				bean.setId(11);
				bean.setFirstName("Ram");
				bean.setLastName("Birla");
				bean.setLogin("luvchopra12@gmail.com");
				bean.setPassword("Ram@123");
				bean.setDob(sdf.parse("2004-10-03"));
				
				
				model.add(bean);

			}
}
