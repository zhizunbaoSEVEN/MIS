/*数据库操作员工信息*/
package EntSystem;
import java.sql.*;

import javax.swing.JOptionPane;
public class InfoStaBase {
	String number,name,sex,age,ifbo;
	public void addStaInf(String number,String name,String sex,String age){
		//增加员工信息
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.age = age;
		try
		{
			Connection con1 = Sql.getConnection();
			Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = stmt1.executeQuery("SELECT Snumber,Sname,Ssex,Sage,Sifbo FROM stainfbase");
			rs1.moveToInsertRow();
			rs1.updateString("Snumber", number);
			rs1.updateString("Sname", name);
			rs1.updateString("Ssex", sex);
			rs1.updateString("Sage", age);
			rs1.updateString("Sifbo", "无");
			rs1.insertRow();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "保存失败","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void editStaInf(int i,String number,String name,String sex,String age){
		//修改员工信息
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.age = age;
		try
		{
			Connection con2 = Sql.getConnection();
			Statement stmt2 = con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs3 = stmt2.executeQuery("SELECT Snumber,Sname,Ssex,Sage FROM stainfbase");
			rs3.absolute(i);
			rs3.updateString("Snumber", number);
			rs3.updateString("Sname",name);
			rs3.updateString("Ssex", sex);
			rs3.updateString("Sage", age);
			rs3.updateRow();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void deleStaInf(int j){
		//删除员工信息
		//JOptionPane.showOptionDialog(null, "确定删除？", "提醒", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		try
		{
			Connection con2 = Sql.getConnection();
			Statement stmt3 = con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs5 = stmt3.executeQuery("SELECT Snumber,Sname,Ssex,Sage FROM stainfbase");
			rs5.absolute(j);
			rs5.deleteRow();
			stmt3.close();
			con2.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	public String[] InfoSearNum(String number){
		//用工号查询员工
		String[] s = new String[5];
		this.number = number;
		int x = 0;
		int a = 0;
		String Snumber;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Snumber,Sname,Ssex,Sage,Sifbo FROM stainfbase");
			while(rs.next())
			{
				a++;
			}
			ResultSet rs1 = stmt1.executeQuery("SELECT Snumber,Sname,Ssex,Sage,Sifbo FROM stainfbase");
			Snumber = "a";
			while(!number.equals(Snumber)&&rs1.next())
			{
				Snumber = rs1.getString("Snumber");
				x++;
			}
			if(x==a&&!number.equals(Snumber))
				x++;
			if(x<=a)
			{
				rs1.absolute(x);
				s[0] = rs1.getString("Snumber");
				s[1] = rs1.getString("Sname");
				s[2] = rs1.getString("Ssex");
				s[3] = rs1.getString("Sage");
				s[4] = rs1.getString("Sifbo");
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
	public String[] InfoSearName(String name){
		//用姓名查询员工
		String[] s = new String[4];
		this.name = name;
		int x = 0;
		int a = 0;
		String Sname;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Snumber,Sname,Ssex,Sage FROM stainfbase");
			while(rs.next())
			{
				a++;
			}
			ResultSet rs1 = stmt1.executeQuery("SELECT Snumber,Sname,Ssex,Sage FROM stainfbase");
			Sname = "a";
			while(!name.equals(Sname)&&rs1.next())
			{
				Sname = rs1.getString("Sname");
				x++;
			}
			if(x==a&&!name.equals(Sname))
				x++;
			if(x<=a&&x!=0)
			{
				rs1.absolute(x);
				s[0] = rs1.getString("Snumber");
				s[1] = rs1.getString("Sname");
				s[2] = rs1.getString("Ssex");
				s[3] = rs1.getString("Sage");
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
	public String[][] InfoSearSex(String sex){
		//用性别查询员工
		String[][] s = new String[20][4];
		this.sex = sex;
		int x = 0;
		int a = 0,b = 0,c = 0,d = 0;
		String Ssex;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Snumber,Sname,Ssex,Sage FROM stainfbase");
			while(rs.next())
			{
				a++;
			}
			rs.absolute(a);
			String Ssex1 = rs.getString("Ssex");
			while(c<a&&x<=a){
				ResultSet rs1 = stmt1.executeQuery("SELECT Snumber,Sname,Ssex,Sage FROM stainfbase");
				rs1.absolute(x);
				while(rs1.next())
				{
					Ssex = rs1.getString("Ssex");
					x++;
					if(sex.equals(Ssex))
					{
						break;
					}
				}
				if(x==a&&!sex.equals(Ssex1))
					x++;
				if(x<=a&&x!=0)
				{
					ResultSet rs2 = stmt2.executeQuery("SELECT Snumber,Sname,Ssex,Sage FROM stainfbase");
					rs2.absolute(x);
					s[b][0] = rs2.getString("Snumber");
					s[b][1] = rs2.getString("Sname");
					s[b][2] = rs2.getString("Ssex");
					s[b][3] = rs2.getString("Sage");
					b++;
					d++;
				}
				if(x==a&&sex.equals(Ssex1))
					x++;
				c++;
			}
			if(x>a&&d==0)
				s = null;
			stmt.close();
			stmt1.close();
			stmt2.close();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查询失败","错误",JOptionPane.ERROR_MESSAGE);
		}
		return s;
	}
	public int InfoSearNum1(String number){
		//用工号查询并返回查询结果的行数
		this.number = number;
		int x = 0;
		int a = 0;
		String Snumber;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Snumber,Sname,Ssex,Sage FROM stainfbase");
			while(rs.next())
			{
				a++;
			}
			ResultSet rs1 = stmt1.executeQuery("SELECT Snumber,Sname,Ssex,Sage FROM stainfbase");
			Snumber = "a";
			while(!number.equals(Snumber)&&rs1.next())
			{
				Snumber = rs1.getString("Snumber");
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
	public String[][] InfoSearSta(){
		String[][] s = new String[1000][4];
		int x = 1;
		int a = 0,b = 0;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Snumber,Sname,Ssex,Sage FROM stainfbase");
			while(rs.next())
			{
				a++;
			}
			rs.first();
			while(x<=a)
			{
				ResultSet rs2 = stmt2.executeQuery("SELECT Snumber,Sname,Ssex,Sage,Sifbo FROM stainfbase");
				rs2.absolute(x);
				s[b][0] = rs2.getString("Snumber");
				s[b][1] = rs2.getString("Sname");
				s[b][2] = rs2.getString("Ssex");
				s[b][3] = rs2.getString("Sage");
				b++;
				x++;
			}
			stmt.close();
			stmt2.close();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "查询失败","错误",JOptionPane.ERROR_MESSAGE);
		}
		return s;
	}
}

