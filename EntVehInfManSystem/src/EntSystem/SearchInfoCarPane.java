package EntSystem;
import javax.swing.*;
public class SearchInfoCarPane extends JFrame{
	//�����ѯ��������Ľ���
	JTable jt;
	String number,type,bebo;
	public SearchInfoCarPane(String number,String type,String bebo){
		this.number = number;
		this.type = type;
		this.bebo = bebo;
		this.setTitle("������ѯ���");
		Object[] co = {"���ƺ�","Ʒ��","�Ƿ��ѱ���"};
		Object[][] row = {{number,type,bebo}};
		jt = new JTable(row,co);
		JScrollPane jsp = new JScrollPane(jt);
		this.getContentPane().add(jsp);
	}
}
