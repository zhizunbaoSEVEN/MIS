package EntSystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SureDel  extends JFrame implements ActionListener{
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	Container content = this.getContentPane();
	JLabel jt = new JLabel("确定删除？");
	JButton jb1 = new JButton("确定");
	JButton jb2 = new JButton("取消");
	String number;
	int i;
	public SureDel(String number,int i){
		this.number = number;
		this.i = i;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("提醒");
			jp1.add(jt);
			jp2.add(jb1);
			jp2.add(jb2);
			content.add(jp1,BorderLayout.NORTH);
			content.add(jp2,BorderLayout.SOUTH);
			jb1.addActionListener(this);
			jb2.addActionListener(this);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==jb1)
		{
			if(i==1){
				InfoStaBase isb1 = new InfoStaBase();
				int a = isb1.InfoSearNum1(number);
				isb1.deleStaInf(a);
				JOptionPane.showMessageDialog(null, "删除成功","成功",JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}
			if(i==2){
				InfoCarBase icb1 = new InfoCarBase();
				int a = icb1.InfoSearPlnum1(number);
				icb1.deleCarInf(a);
				JOptionPane.showMessageDialog(null, "删除成功","成功",JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}
		}
		if(obj==jb2)
		{
			this.dispose();
		}
	}
}
