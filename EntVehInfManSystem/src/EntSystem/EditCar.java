package EntSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
public class EditCar extends JFrame implements ActionListener{
	public static Connection getConnection() throws SQLException,java.lang.ClassNotFoundException{
		String url = "jdbc:mysql://localhost:3306/StaCarInf";
		Class.forName("com.mysql.jdbc.Driver");
		String userName = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	Container content = this.getContentPane();
	JTextField plnumber = new JTextField(15);
	JTextField type = new JTextField(15);
	JTextField bebo = new JTextField(15);
	JLabel lplnumber = new JLabel("���ƺ�");
	JLabel ltype = new JLabel("Ʒ��");
	JLabel lbebo = new JLabel("�Ƿ��ѱ���");
	JButton j1 = new JButton("���ƺŲ�ѯ");
	JButton j2 = new JButton("�޸�");
	JButton NOT = new JButton("ȡ��");
	public EditCar(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("�޸ĳ�����Ϣ");
			plnumber.setText("���ѯ���ƺ�");
			jp1.add(lplnumber);
			jp1.add(plnumber);
			jp2.add(ltype);
			jp2.add(type);
			jp2.add(lbebo);
			jp2.add(bebo);
			jp3.add(j1);
			jp3.add(j2);
			jp3.add(NOT);
			content.add(jp1,BorderLayout.NORTH);
			content.add(jp2);
			content.add(jp3,BorderLayout.SOUTH);
			j1.addActionListener(this);
			j2.addActionListener(this);
			NOT.addActionListener(this);
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==j2){
			InfoCarBase isbc = new InfoCarBase();
			int a = isbc.InfoSearPlnum1(plnumber.getText());
			isbc.editCarInf(a,plnumber.getText(),type.getText(),bebo.getText());
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�","�ɹ�",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(obj==j1){
			InfoCarBase isbc2 = new InfoCarBase();
			String[] s = isbc2.InfoSearPlnum(plnumber.getText());
			if(s==null){
				JOptionPane.showMessageDialog(null, "��¼������");
				plnumber.setText("���ѯ���ƺ�");
				type.setText("");
				bebo.setText("");
			}
			else{
				plnumber.setText(s[0]);
				type.setText(s[1]);
				bebo.setText(s[2]);
			}
		}
		else if(obj==NOT){
			this.dispose();
		}
	}
}
