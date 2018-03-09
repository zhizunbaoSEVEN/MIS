package EntSystem;
import java.sql.*;
import javax.swing.JOptionPane;
public class AddReInf {
	String number,name,plnumber,recarday;
	public AddReInf(String number,String name,String plnumber,String recarday){
		this.number = number;
		this.name = name;
		this.plnumber = plnumber;
		this.recarday = recarday;
		try
		{
			Connection con1 = Sql.getConnection();
			Statement stmt1 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt2 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			Statement stmt3 = con1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1 = stmt1.executeQuery("SELECT Snumber,Sname,Splnumber,Srecarday,Skey FROM boorecarbase");
			InfoBooReBase ibrb = new InfoBooReBase();
			int x = ibrb.InfoSearBooReNum1();
			x--;
			int y = ibrb.InfoSearBooReNum(x);
			rs1.absolute(y);
			rs1.updateString("Srecarday", recarday);
			rs1.updateRow();
			ResultSet rs2 = stmt2.executeQuery("SELECT Splnumber,Stype,Sbebo FROM carinfbase");
			InfoCarBase icb = new InfoCarBase();
			int a = icb.InfoSearPlnum1(plnumber);
			rs2.absolute(a);
			rs2.updateString("Sbebo", "ÎÞ");
			rs2.updateRow();
			ResultSet rs3 = stmt3.executeQuery("SELECT Snumber,Sname,Ssex,Sage,Sifbo FROM stainfbase");
			InfoStaBase isb = new InfoStaBase();
			int b = isb.InfoSearNum1(number);
			rs3.absolute(b);
			rs3.updateString("Sifbo", "ÎÞ");
			rs3.updateRow();
			con1.close();
			stmt1.close();
			stmt2.close();
			stmt3.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ê§°Ü","´íÎó",JOptionPane.ERROR_MESSAGE);
		}
	}
}
