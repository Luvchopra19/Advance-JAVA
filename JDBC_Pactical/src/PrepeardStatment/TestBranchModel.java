package PrepeardStatment;

public class TestBranchModel {
public static void main(String[] args) throws Exception {
	TestUpdate();
	Testdelete();
	
}

private static void Testdelete() throws Exception {
	
	BranchModel model = new BranchModel();
	BranchBean bean = new BranchBean();
	
	bean.setId(3);
	model.delete(bean);
}

private static void TestUpdate() throws Exception {
	
	BranchModel model = new BranchModel();
	BranchBean bean = new BranchBean();
	
	bean.setId(5);
	bean.setBranchName("HDFC");
	bean.setManagerName("Shivam");
	bean.setBranchName("Benglor");
	bean.setContatctNo(56789012);
	
	model.Update(bean);
	
	
}
}
