package PrepeardStatment;


public class TestMarkSheetModel {

	public static void main(String[] args) throws Exception {
		
	}

	private static void testUpdate() throws Exception {
		MarkSheetBean bean = new MarkSheetBean();
		MarkSheetModel model = new MarkSheetModel();
		
		bean.setId(16);
		bean.setRollNo("116");
		bean.setName("Naman");
		bean.setphy(56);
		bean.setChm(65);
		bean.setMaths(75);

model.update(bean);
	}
	public static void testDelete() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(5);

		model.delete(bean);
	}
	
}