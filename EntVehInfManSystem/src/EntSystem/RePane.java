package EntSystem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RePane extends JFrame implements ActionListener{
	//还车界面
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	Container content = this.getContentPane();
	JTextField number = new JTextField(15);
	JTextField name = new JTextField(15);
	JTextField plnumber = new JTextField(15);
	JTextField recarday = new JTextField(15);
	JLabel lnumber = new JLabel("工号");
	JLabel lname = new JLabel("姓名");
	JLabel lplnumber = new JLabel("车牌号");
	JLabel lrecarday = new JLabel("还车日期");
	JButton OK = new JButton("确定");
	JButton NOT = new JButton("取消");
	public RePane(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("还车");
			jp1.add(lnumber);
			jp1.add(number);
			jp1.add(lname);
			jp1.add(name);
			jp2.add(lplnumber);
			jp2.add(plnumber);
			jp2.add(lrecarday);
			jp2.add(recarday);
			jp3.add(OK);
			jp3.add(NOT);
			content.add(jp1,BorderLayout.NORTH);
			content.add(jp2,BorderLayout.CENTER);
			content.add(jp3,BorderLayout.SOUTH);
			OK.addActionListener(this);
			NOT.addActionListener(this);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==OK){
			InfoCarBase icb = new InfoCarBase();
			String[] s = icb.InfoSearPlnum(plnumber.getText());
			InfoStaBase isb = new InfoStaBase();
			String[] s1 = isb.InfoSearNum(number.getText());
			if(s!=null&&s1!=null){
				if(s[2].equals("是")&&s1[4].equals("是")){
					AddReInf ari = new AddReInf(number.getText(),name.getText(),plnumber.getText(),recarday.getText());
					JOptionPane.showMessageDialog(null, "成功","成功",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(s1[4].equals("无"))
				{
					JOptionPane.showMessageDialog(null, "失败","请先借车",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "失败","请检查工号和车牌号",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(obj==NOT){
			this.dispose();
		}
	}
}
