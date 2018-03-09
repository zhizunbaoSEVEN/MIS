package EntSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class BooReCar extends JFrame implements ActionListener{
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	Container content = this.getContentPane();
	JButton lbo = new JButton("借车");
	JButton lre = new JButton("还车");
	JButton jb = new JButton("取消");
	public BooReCar(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("借还车");
			jp1.add(lbo);
			jp1.add(lre);
			jp2.add(jb);
			content.add(jp1,BorderLayout.NORTH);
			content.add(jp2,BorderLayout.SOUTH);
			lbo.addActionListener(this);
			lre.addActionListener(this);
			jb.addActionListener(this);
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj == lbo){
			BoPane bp = new BoPane();
			bp.pack();
			bp.setVisible(true);
		}
		if(obj == lre){
			RePane rp = new RePane();
			rp.pack();
			rp.setVisible(true);
		}
		if(obj==jb){
			this.dispose();
		}
	}
}
