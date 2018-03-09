package EntSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class InfoUserBase {
	String user,password;
	private String number;
	public void addUserInf(String user,String password){
		//增加用户信息
		this.user = user;
		this.password= password;
		try
		{
			Connection con1 = Sql.getConnection();
			Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = stmt1.executeQuery("SELECT Sname,Spassword FROM userbase");
			rs1.moveToInsertRow();
			rs1.updateString("Sname", user);
			rs1.updateString("Spassword", password);
			rs1.insertRow();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "保存失败","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	public String[] InfoSearNum(String user){
		//用用户名查询用户
		String[] s = new String[5];
		this.user = user;
		int x = 0;
		int a = 0;
		String Suser;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Sname,Spassword FROM userbase");
			while(rs.next())
			{
				a++;
			}
			ResultSet rs1 = stmt1.executeQuery("SELECT Sname,Spassword FROM userbase");
			Suser = "a";
			while(!user.equals(Suser)&&rs1.next())
			{
				Suser = rs1.getString("Sname");
				x++;
			}
			if(x==a&&!user.equals(Suser))
				x++;
			if(x<=a)
			{
				rs1.absolute(x);
				s[0] = rs1.getString("Sname");
				s[1] = rs1.getString("Spassword");
			}
			else
			{
				s = null;
			}
			stmt.close();
			stmt1.close();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查询失败","错误",JOptionPane.ERROR_MESSAGE);
		}
		return s;
	}
	public int InfoSearNum1(String number){
		//用用户名查询并返回查询结果的行数
		this.number = number;
		int x = 0;
		int a = 0;
		String Snumber;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT * FROM userbase");
			while(rs.next())
			{
				a++;
			}
			ResultSet rs1 = stmt1.executeQuery("SELECT * FROM userbase");
			Snumber = "a";
			while(!number.equals(Snumber)&&rs1.next())
			{
				Snumber = rs1.getString("Sname");
				x++;
			}
			stmt.close();
			stmt1.close();
			con.close();
			if(x<=a)
			{
				return x;
			}
			else
			{
				x = 0;
				return x;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查询失败","错误",JOptionPane.ERROR_MESSAGE);
			return x = 0;
		}
	}
	public int deleUserInf(int j){
		//删除用户信息
		try{
			Connection con2 = Sql.getConnection();
			Statement stmt3 = con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs5 = stmt3.executeQuery("SELECT * FROM userbase");
			rs5.absolute(j);
			rs5.deleteRow();
			stmt3.close();
			con2.close();
			return 1;
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败","错误",JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}
}
