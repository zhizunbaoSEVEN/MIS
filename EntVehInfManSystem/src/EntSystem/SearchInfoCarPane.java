package EntSystem;
import javax.swing.*;
public class SearchInfoCarPane extends JFrame{
	//输出查询车辆结果的界面
	JTable jt;
	String number,type,bebo;
	public SearchInfoCarPane(String number,String type,String bebo){
		this.number = number;
		this.type = type;
		this.bebo = bebo;
		this.setTitle("车辆查询情况");
		Object[] co = {"车牌号","品牌","是否已被借"};
		Object[][] row = {{number,type,bebo}};
		jt = new JTable(row,co);
		JScrollPane jsp = new JScrollPane(jt);
		this.getContentPane().add(jsp);
	}
}
