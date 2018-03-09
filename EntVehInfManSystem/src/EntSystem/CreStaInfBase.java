package EntSystem;
import java.sql.*;
public class CreStaInfBase {
	public static void main(String[] args){
		try
		{
			Connection con = Sql.getConnection();
			Statement sql = con.createStatement();
			sql.executeUpdate("drop table if exists boorecarbase");
			sql.executeUpdate("drop table if exists stainfbase");
			sql.executeUpdate("drop table if exists carinfbase");
			sql.executeUpdate("drop table if exists userbase");
			sql.executeUpdate("create table stainfbase(Snumber char(20) not null,Sname nchar(20) not null,Ssex nchar(20) not null,Sage char(20) not null,Sifbo nchar(20) not null,primary key(Snumber));");
			sql.executeUpdate("create table carinfbase(Splnumber char(20) not null,Stype nchar(20) not null,Sbebo nchar(20) not null,primary key(Splnumber));");
			sql.executeUpdate("create table boorecarbase(Skey int not null,Snumber char(20) not null, Sname nchar(20) not null,Splnumber char(20) not null,Sbocarday nchar(20),Srecarday nchar(20),primary key(Skey),foreign key(Snumber) references stainfbase(Snumber),foreign key(Splnumber) references carinfbase(Splnumber));");
			sql.executeUpdate("create table userbase(Sname nchar(20) not null,Spassword char(20) not null,primary key(Sname));");
			sql.executeUpdate("insert stainfbase values('1','����','��',21,'��')");
			sql.executeUpdate("insert stainfbase values('2','����','��',22,'��')");
			sql.executeUpdate("insert stainfbase values('3','��һ','��',23,'��')");
			sql.executeUpdate("insert stainfbase values('4','Ǯ��','��',24,'��')");
			sql.executeUpdate("insert stainfbase values('5','����','��',25,'��')");
			sql.executeUpdate("insert stainfbase values('6','����','Ů',25,'��')");
			sql.executeUpdate("insert stainfbase values('7','��˼','��',26,'��')");
			sql.executeUpdate("insert stainfbase values('8','֣��','Ů',24,'��')");
			sql.executeUpdate("insert carinfbase values('123456','����','��')");
			sql.executeUpdate("insert carinfbase values('123457','����','��')");
			sql.executeUpdate("insert carinfbase values('123458','�µ�','��')");
			sql.executeUpdate("insert userbase values('7890@qq.com','123')");
			sql.close();
			con.close();
		}catch(java.lang.ClassNotFoundException e){
			System.err.println("ClassNotFoundException:");
			System.err.println(e.getMessage());
		}catch(SQLException ex){
			System.err.println("SQLException:"+ex.getMessage());
		}
	}
}
