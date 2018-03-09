package EntSystem;
import java.awt.FlowLayout;
import java.sql.*;

import javax.swing.*;
import javax.swing.*;
import javax.swing.*;
public class LandCheck {
	String userName,password;
	public LandCheck(String userName,String password){
		this.userName = userName;
		this.password = password;
	}
	public void init(){
		try
		{
			Connection con = Sql.getConnection();
			String sql = "select Sname,Spassword from userbase where Sname= ? and Spassword= ?";
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setString(1, userName);
			stat.setString(2, password);
			ResultSet rs = stat.executeQuery();
			if(rs.next()==true)
			{
				Menu m =new Menu(userName);
				m.setLayout(new FlowLayout());
				m.setSize(500,250);
				m.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"账号不存在或者密码错误");
				Land l1 = new Land();
				l1.pack();
				l1.setVisible(true);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
