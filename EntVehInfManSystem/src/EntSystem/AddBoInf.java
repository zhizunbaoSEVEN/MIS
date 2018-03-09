package EntSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AddBoInf {
	String number,name,plnumber,bocarday;
	public AddBoInf(String number,String name,String plnumber,String bocarday){
		//增加员工借车信息
		this.number = number;
		this.name = name;
		this.plnumber = plnumber;
		this.bocarday = bocarday;
		try
		{
			Connection con1 = Sql.getConnection();
			Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt2 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt3 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = stmt1.executeQuery("SELECT Snumber,Sname,Splnumber,Sbocarday,Skey FROM boorecarbase");
			InfoBooReBase isbrn1 = new InfoBooReBase();
			int y = isbrn1.InfoSearBooReNum1();
			rs1.moveToInsertRow();
			rs1.updateString("Snumber", number);
			rs1.updateString("Sname", name);
			rs1.updateString("Splnumber", plnumber);
			rs1.updateString("Sbocarday", bocarday);
			rs1.updateInt("Skey", y);
			rs1.insertRow();
			ResultSet rs2 = stmt2.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
			InfoCarBase icb = new InfoCarBase();
			int a = icb.InfoSearPlnum1(plnumber);
			rs2.absolute(a);
			rs2.updateString("Sbebo", "是");
			rs2.updateRow();
			ResultSet rs3 = stmt3.executeQuery("SELECT Snumber,Sname,Ssex,Sage,Sifbo FROM stainfbase");
			InfoStaBase isb = new InfoStaBase();
			int b = isb.InfoSearNum1(number);
			rs3.absolute(b);
			rs3.updateString("Sifbo", "是");
			rs3.updateRow();
			con1.close();
			stmt1.close();
			stmt2.close();
			stmt3.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
}
