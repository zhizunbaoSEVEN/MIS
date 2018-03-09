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

public class SearchMotype extends JFrame implements ActionListener{
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	Container content = this.getContentPane();
	JTextField type = new JTextField(15);
	JLabel ltype = new JLabel("Ʒ��");
	JButton OK = new JButton("ȷ��");
	JButton NOT = new JButton("ȡ��");
	public SearchMotype(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("Ʒ�Ʋ�ѯ����");
			jp1.add(ltype);
			jp1.add(type);
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
			InfoCarBase isb = new InfoCarBase();
			String s[][] = isb.InfoSearType(type.getText());
			if(s!=null)
			{
				SearchManyInfoCarPane sip = new SearchManyInfoCarPane(s);
				sip.pack();
				sip.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(null, "��ѯʧ��","����",JOptionPane.ERROR_MESSAGE);
		}
		else if(obj==NOT){
			this.dispose();
		}
	}
}
