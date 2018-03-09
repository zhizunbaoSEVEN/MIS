package EntSystem;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Land extends JFrame implements ActionListener{
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	Container content = this.getContentPane();
	JButton b = new JButton("µÇÂ½");
	JButton b1 = new JButton("×¢²á");
	JTextField userName = new JTextField(20);
	JPasswordField password = new JPasswordField(20);
	JLabel J1 = new JLabel("ÓÃ»§Ãû");
	JLabel J2 = new JLabel(" ÃÜÂë   ");
	public Land(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		setTitle("µÇÂ½");
		jp1.add(J1);
		jp1.add(userName);
		jp2.add(J2);
		jp2.add(password);
		jp3.add(b);
		jp3.add(b1);
		content.add(jp1,BorderLayout.NORTH);
		content.add(jp2,BorderLayout.CENTER);
		content.add(jp3,BorderLayout.SOUTH);
		b.addActionListener(this);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==b){
			String password1 = new String(password.getPassword());
			LandCheck lc = new LandCheck(userName.getText(),password1);
			lc.init();
			this.setVisible(false);
		}
		else
		{
			AddUser au = new AddUser();
			au.pack();
			au.setVisible(true);
		}
	}
}