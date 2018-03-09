package EntSystem;
import javax.swing.*;
public class SearchManyInfoCarPane extends JFrame{
	//输出查询多部车辆结果的界面
	JTable jt;
	String number,type;
	int i = 0;
	String[][] s = new String[20][2];
	public SearchManyInfoCarPane(String[][] s){
		this.s = s;
		this.setTitle("车辆查询情况");
		Object[] co = {"车牌号","品牌","是否已被借"};
		Object[][] ob = new Object[20][3];
		while(s[i][0] != null&&s[i][1] != null&&s[i][2] != null)
		{
			ob[i][0] = s[i][0];
			ob[i][1] = s[i][1];
			ob[i][2] = s[i][2];
			i++;
		}
		jt = new JTable(ob,co);
		JScrollPane jsp = new JScrollPane(jt);
		this.getContentPane().add(jsp);
	}
}