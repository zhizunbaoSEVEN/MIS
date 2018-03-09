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

public class SearchSex extends JFrame implements ActionListener{
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	Container content = this.getContentPane();
	JTextField sex = new JTextField(15);
	JLabel lsex = new JLabel("性别");
	JButton OK = new JButton("确定");
	JButton NOT = new JButton("取消");
	public SearchSex(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("性别查询员工");
			jp1.add(lsex);
			jp1.add(sex);
			jp2.add(OK);
			jp2.add(NOT);
			content.add(jp1,BorderLayout.NORTH);
			content.add(jp2,BorderLayout.SOUTH);
			OK.addActionListener(this);
			NOT.addActionListener(this);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==OK)
		{
			InfoStaBase isb = new InfoStaBase();
			String s[][] = isb.InfoSearSex(sex.getText());
			if(s!=null)
			{
				SearchManyInfoStafPane sip = new SearchManyInfoStafPane(s);
				sip.pack();
				sip.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(null, "查询失败","错误",JOptionPane.ERROR_MESSAGE);
		}
		else if(obj==NOT){
			this.dispose();
		}
	}
}
