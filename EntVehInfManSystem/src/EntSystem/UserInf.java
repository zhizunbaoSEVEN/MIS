package EntSystem;
import java.sql.*;

import javax.swing.*;
public class UserInf extends JFrame{
	public UserInf(){
		try
		{
			Connection con1 = Sql.getConnection();
			Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = stmt1.executeQuery("SELECT Sname FROM userbase");
			rs1.first();
			con1.close();
			stmt1.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "失败","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	JTable jt;
	public void SearchInfoUserPane(){
		this.setTitle("个人信息");
		Object[] co = {"账号"};
		Object[][] row = {{"7890@qq.com"}};
		jt = new JTable(row,co);
		JScrollPane jsp = new JScrollPane(jt);
		this.getContentPane().add(jsp);
	}
}
