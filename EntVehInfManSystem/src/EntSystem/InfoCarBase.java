/*数据库操作车辆信息*/
package EntSystem;
import java.sql.*;

import javax.swing.JOptionPane;
public class InfoCarBase {
	String plnumber,type,bebo;
	public void addCarInf(String plnumber,String type,String bebo){
		//增加车辆信息
		this.plnumber = plnumber;
		this.type = type;
		this.bebo = bebo;
		try
		{
			Connection con1 = Sql.getConnection();
			Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = stmt1.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
			rs1.moveToInsertRow();
			rs1.updateString("Splnumber", plnumber);
			rs1.updateString("Stype", type);
			rs1.updateString("Sbebo",bebo);
			rs1.insertRow();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "保存失败","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void editCarInf(int i,String plnumber,String type,String bebo){
		//修改车辆信息
		this.plnumber = plnumber;
		this.type = type;
		this.bebo = bebo;
		try
		{
			Connection con2 = Sql.getConnection();
			Statement stmt3 = con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs3 = stmt3.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
			rs3.absolute(i);
			rs3.updateString("Splnumber", plnumber);
			rs3.updateString("Stype",type);
			rs3.updateString("Sbebo", bebo);
			rs3.updateRow();
			stmt3.close();
			con2.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void deleCarInf(int j){
		//删除车辆信息
		try{
			Connection con2 = Sql.getConnection();
			Statement stmt3 = con2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs5 = stmt3.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
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
	public String[] InfoSearPlnum(String plnumber){
		//用车牌号查询车辆
		String[] s = new String[3];
		this.plnumber = plnumber;
		int x = 0;
		int a = 0;
		String Splnumber;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
			while(rs.next())
			{
				a++;
			}
			ResultSet rs1 = stmt1.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
			Splnumber = "a";
			while(!plnumber.equals(Splnumber)&&rs1.next())
			{
				Splnumber = rs1.getString("Splnumber");
				x++;
			}
			if(x==a&&!plnumber.equals(Splnumber))
				x++;
			if(x<=a)
			{
				rs1.absolute(x);
				s[0] = rs1.getString("Splnumber");
				s[1] = rs1.getString("Stype");
				s[2] = rs1.getString("Sbebo");
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
	public String[][] InfoSearType(String type){
		//用品牌查询车辆
		String[][] s = new String[20][3];
		this.type = type;
		int x = 0;
		int a = 0,b = 0,c = 0,d = 0;
		String Stype;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
			while(rs.next())
			{
				a++;
			}
			rs.absolute(a);
			String Stype1 = rs.getString("Stype");
			while(c<a&&x<=a){
				ResultSet rs1 = stmt1.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
				rs1.absolute(x);
				while(rs1.next())
				{
					Stype = rs1.getString("Stype");
					x++;
					if(type.equals(Stype))
					{
						break;
					}
				}
				if(x==a&&!type.equals(Stype1))
					x++;
				if(x<=a&&x!=0)
				{
					ResultSet rs2 = stmt2.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
					rs2.absolute(x);
					s[b][0] = rs2.getString("Splnumber");
					s[b][1] = rs2.getString("Stype");
					s[b][2] = rs2.getString("Sbebo");
					b++;
					d++;
				}
				if(x==a&&type.equals(Stype1))
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
	public int InfoSearPlnum1(String plnumber){
		//用车牌号查询并返回查询结果的行数
		this.plnumber = plnumber;
		int x = 0;
		int a = 0;
		String Splnumber;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
			while(rs.next())
			{
				a++;
			}
			ResultSet rs1 = stmt1.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
			Splnumber = "a";
			while(!plnumber.equals(Splnumber)&&rs1.next())
			{
				Splnumber = rs1.getString("Splnumber");
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
	public String[][] InfoSearCar(){
		String[][] s = new String[1000][3];
		int x = 1;
		int a = 0,b = 0;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
			while(rs.next())
			{
				a++;
			}
			rs.first();
			while(x<=a)
			{
				ResultSet rs2 = stmt2.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
				rs2.absolute(x);
				s[b][0] = rs2.getString("Splnumber");
				s[b][1] = rs2.getString("Stype");
				s[b][2] = rs2.getString("Sbebo");
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

