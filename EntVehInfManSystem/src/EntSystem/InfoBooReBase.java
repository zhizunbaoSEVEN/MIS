package EntSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class InfoBooReBase {
	int i;
	String Snumber;
	public int InfoSearBooReNum(int i){
		//�ùؼ��Ų�ѯ�����ز�ѯ���������
		this.i = i;
		int x = 1;
		int a = 0;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Snumber,Sname,Splnumber,Skey FROM boorecarbase");
			while(rs.next())
			{
				a++;
			}
			while(x!=i&&i!=0)
			{
				x++;
			}
			stmt.close();
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
			JOptionPane.showMessageDialog(null, "��ѯʧ��","����",JOptionPane.ERROR_MESSAGE);
			return x = 0;
		}
	}
	public int InfoSearBooReNum1(){
		//���ر������
		int a = 1;
		try
		{
			Connection con = Sql.getConnection();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT Snumber,Sname,Splnumber FROM boorecarbase");
			while(rs.next())
			{
				a++;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��ѯʧ��","����",JOptionPane.ERROR_MESSAGE);
		}
		return a;
	}
}
