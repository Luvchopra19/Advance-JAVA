package PrepeardStatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BranchModel {

	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
	
	String Driver = rb.getString("driver");
	String url = rb.getString("url");
	String username = rb.getString("username");
	String password = rb.getString("password");
	
	public int add (BranchBean bean) throws Exception {
		
		Class.forName(Driver);
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		PreparedStatement pst = con.prepareStatement("insert into branch values(?, ?, ?, ?, ?)");
		
		pst.setInt(1, bean.getId());
		pst.setString(2, bean.getBranchName());
		pst.setString(3, bean.getCity());
		pst.setString(4, bean.getManagerName());
		pst.setInt(5, bean.getContatctNo());
		
		int i = pst.executeUpdate();
		
		System.out.println(i + "rollafected(Branch added)");
		
		return bean.getId();
		
	}
	public void Update(BranchBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays");
		
		PreparedStatement pst = con.prepareStatement("update branch set branchName = ?, city = ?, managerName = ?, contectNumber = ?, where id = ?");
		
		pst.setString(1, bean.getBranchName());
		pst.setString(2, bean.getCity());
		pst.setString(3, bean.getManagerName());
		pst.setInt(4, bean.getContatctNo());
		pst.setInt(5, bean.getId());
		
		int i = pst.executeUpdate();
		
		System.out.println(i + "rollafected(Branch Update)");
		
		con.close();
		pst.close();
		
	}
	public void delete(BranchBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays");
		
		PreparedStatement pst = con.prepareStatement("delete from branch where id = ?");
		
		pst.setString(1, bean.getBranchName());
		pst.setString(2, bean.getCity());
		pst.setString(3, bean.getManagerName());
		pst.setInt(4, bean.getContatctNo());
		pst.setInt(5, bean.getId());
		
		int i = pst.executeUpdate();
		
		System.out.println(i + "rollafected(Branch delete)");
		
		con.close();
		pst.close();
		
	}
	public BranchBean findBybranchName(String branchName) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays");
		
		PreparedStatement pst = con.prepareStatement("select * from branch where branchName = ?");
		
		pst.setString(1, branchName);

		BranchBean bean = null;

		ResultSet rs = pst.executeQuery();

	    while(rs.next()) {
	    	bean = new BranchBean();
	    	bean.setId(rs.getInt(1));
	    	bean.setBranchName(rs.getString(2));
	    	bean.setCity(rs.getString(3));
	    	bean.setManagerName(rs.getString(4));
	    	bean.setContatctNo(rs.getInt(5));
	    }
	    return bean;
	}
public BranchBean findByPK(int pk) throws Exception{ 
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays");
		
		PreparedStatement pst = con.prepareStatement("select * from branch where branchName = ?");
		
		pst.setInt(1, pk);
		BranchBean bean = null;
		
		ResultSet rs = pst.executeQuery();
		
		 while(rs.next()) {
		    	bean = new BranchBean();
		    	bean.setId(rs.getInt(1));
		    	bean.setBranchName(rs.getString(2));
		    	bean.setCity(rs.getString(3));
		    	bean.setManagerName(rs.getString(4));
		    	bean.setContatctNo(rs.getInt(5));
		    }
		return bean;
}
public List<BranchBean> search(BranchBean bean) throws Exception{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays");
	
	StringBuffer sql = new StringBuffer("select * from branch where 1 = 1");
	
	if (bean != null) {
		if (bean.getBranchName() != null && bean.getBranchName().length() > 0) {
			sql.append(" and name like '" + bean.getBranchName() + "'");
		}
	}
	System.out.println("sql ===== > " + sql.toString());

	PreparedStatement pstmt = con.prepareStatement(sql.toString());

	ResultSet rs = pstmt.executeQuery();

	List list = new ArrayList();

	 while(rs.next()) {
	    	bean = new BranchBean();
	    	bean.setId(rs.getInt(1));
	    	bean.setBranchName(rs.getString(2));
	    	bean.setCity(rs.getString(3));
	    	bean.setManagerName(rs.getString(4));
	    	bean.setContatctNo(rs.getInt(5));
	    }
	return list;
}
}
	

