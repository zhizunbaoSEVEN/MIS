package EntSystem;
import javax.swing.*;
public class SearchInfoStafPane extends JFrame{
	//输出查询员工结果的界面
	JTable jt;
	String number,name,sex,age;
	public SearchInfoStafPane(String number,String name,String sex,String age){
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.setTitle("员工查询情况");
		Object[] co = {"工号","姓名","性别","年龄"};
		Object[][] row = {{number,name,sex,age}};
		jt = new JTable(row,co);
		JScrollPane jsp = new JScrollPane(jt);
		this.getContentPane().add(jsp);
	}
}
