package EntSystem;
import javax.swing.*;
public class SearchManyInfoStafPane extends JFrame{
	//输出查询多名员工结果的界面
	JTable jt;
	int i = 0;
	String[][] s = new String[1000][4];
	public SearchManyInfoStafPane(String[][] s){
		this.s = s;
		this.setTitle("员工查询情况");
		Object[] co = {"工号","姓名","性别","年龄"};
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