package EntSystem;
import javax.swing.*;
public class SearchInfoStafPane extends JFrame{
	//�����ѯԱ������Ľ���
	JTable jt;
	String number,name,sex,age;
	public SearchInfoStafPane(String number,String name,String sex,String age){
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.setTitle("Ա����ѯ���");
		Object[] co = {"����","����","�Ա�","����"};
		Object[][] row = {{number,name,sex,age}};
		jt = new JTable(row,co);
		JScrollPane jsp = new JScrollPane(jt);
		this.getContentPane().add(jsp);
	}
}
