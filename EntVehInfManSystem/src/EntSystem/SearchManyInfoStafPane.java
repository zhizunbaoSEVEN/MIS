package EntSystem;
import javax.swing.*;
public class SearchManyInfoStafPane extends JFrame{
	//�����ѯ����Ա������Ľ���
	JTable jt;
	int i = 0;
	String[][] s = new String[1000][4];
	public SearchManyInfoStafPane(String[][] s){
		this.s = s;
		this.setTitle("Ա����ѯ���");
		Object[] co = {"����","����","�Ա�","����"};
		Object[][] ob = new Object[20][4];
		while(s[i][0] != null&&s[i][1] != null&&s[i][2] != null&&s[i][3] != null)
		{
			ob[i][0] = s[i][0];
			ob[i][1] = s[i][1];
			ob[i][2] = s[i][2];
			ob[i][3] = s[i][3];
			i++;
		}
		jt = new JTable(ob,co);
		JScrollPane jsp = new JScrollPane(jt);
		this.getContentPane().add(jsp);
	}
}