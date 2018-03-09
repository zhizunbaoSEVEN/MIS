package EntSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Menu extends JFrame implements ActionListener{
	JPanel jp = new JPanel();
	JMenuBar JMB = new JMenuBar();
	JMenu j1 = new JMenu("员工管理");
	JMenu j2 = new JMenu("车辆管理");
	JMenu j3 = new JMenu("信息查询");
	JMenu help = new JMenu("帮助");
	JMenu user = new JMenu("个人中心");
	JMenuItem jmi1_1 = new JMenuItem("增加");
	JMenuItem jmi1_2 = new JMenuItem("修改");
	JMenuItem jmi1_3 = new JMenuItem("删除");
	JMenuItem jmi1_4 = new JMenuItem("借还车");
	JMenuItem jmi2_1 = new JMenuItem("增加");
	JMenuItem jmi2_2 = new JMenuItem("修改");
	JMenuItem jmi2_3 = new JMenuItem("删除");
	JMenu jmi3_1 = new JMenu("员工查询");
	JMenu jmi3_2 = new JMenu("车辆查询");
	JMenuItem jmi3_1_1 = new JMenuItem("按工号查询");
	JMenuItem jmi3_1_2 = new JMenuItem("按姓名查询");
	JMenuItem jmi3_1_3 = new JMenuItem("按性别查询");
	JMenuItem jmi3_2_1 = new JMenuItem("按车牌号查询");
	JMenuItem jmi3_2_2 = new JMenuItem("按品牌查询"); 
	JMenuItem jmi3_3 = new JMenuItem("查看全部员工信息");
	JMenuItem jmi3_4 = new JMenuItem("查看全部车辆信息");
	JMenuItem jmiuser_1 = new JMenuItem("个人信息");
	JMenuItem jmiuser_2 = new JMenuItem("退出");
	JMenuItem jmiuser_3 = new JMenuItem("注销");
	String Suser;
	public Menu(String Sname){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{
			Suser = Sname;
			this.setResizable(true);
		    this.setTitle("企业车辆信息管理系统");
		    setJMenuBar(JMB);
			JMB.add(j1);
			JMB.add(j2);
			JMB.add(j3);
			JMB.add(user);
			JMB.add(help);
			j1.add(jmi1_1);
			j1.add(jmi1_2);
			j1.add(jmi1_3);
			j1.add(jmi1_4);
			j2.add(jmi2_1);
			j2.add(jmi2_2);
			j2.add(jmi2_3);
			jmi3_1.add(jmi3_1_1);
			jmi3_1.add(jmi3_1_2);
			jmi3_1.add(jmi3_1_3);
			j3.add(jmi3_1);
			jmi3_2.add(jmi3_2_1);
			jmi3_2.add(jmi3_2_2);
			j3.add(jmi3_2);
			j3.add(jmi3_3);
			j3.add(jmi3_4);
			user.add(jmiuser_1);
			user.add(jmiuser_3);
			user.add(jmiuser_2);
			jmi1_1.addActionListener(this);
			jmi1_2.addActionListener(this);
			jmi1_3.addActionListener(this);
			jmi1_4.addActionListener(this);
			jmi2_1.addActionListener(this);
			jmi2_2.addActionListener(this);
			jmi2_3.addActionListener(this);
			jmi3_1_1.addActionListener(this);
			jmi3_1_2.addActionListener(this);
			jmi3_1_3.addActionListener(this);
			jmi3_2_1.addActionListener(this);
			jmi3_2_2.addActionListener(this);
			jmi3_3.addActionListener(this);
			jmi3_4.addActionListener(this);
			jmiuser_1.addActionListener(this);
			jmiuser_2.addActionListener(this);
			jmiuser_3.addActionListener(this);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==jmi1_1){
			AddSta as = new AddSta();
			as.pack();
			as.setVisible(true);
		}
		else if(obj==jmi1_2){
			EditSta es = new EditSta();
			es.pack();
			es.setVisible(true);
		}
		else if(obj==jmi1_3){
			DelSta ds = new DelSta();
			ds.pack();
			ds.setVisible(true);
		}
		else if(obj==jmi1_4){
			BooReCar brc = new BooReCar();
			brc.pack();
			brc.setVisible(true);
		}
		else if(obj==jmi2_1){
			AddCar ac = new AddCar();
			ac.pack();
			ac.setVisible(true);
		}
		else if(obj==jmi2_2){
			EditCar ec = new EditCar();
			ec.pack();
			ec.setVisible(true);
		}
		else if(obj==jmi2_3){
			DelCar dc = new DelCar();
			dc.pack();
			dc.setVisible(true);
		}
		else if(obj==jmi3_1_1){
			SearchNum sn = new SearchNum();
			sn.pack();
			sn.setVisible(true);
		}
		else if(obj==jmi3_1_2){
			SearchName sna = new SearchName();
			sna.pack();
			sna.setVisible(true);
		}
		else if(obj==jmi3_1_3){
			SearchSex ss = new SearchSex();
			ss.pack();
			ss.setVisible(true);
		}
		else if(obj==jmi3_2_1){
			SearchPlnum sp = new SearchPlnum();
			sp.pack();
			sp.setVisible(true);
		}
		else if(obj==jmi3_2_2){
			SearchMotype sm = new SearchMotype();
			sm.pack();
			sm.setVisible(true);
		}
		else if(obj==jmi3_3){
			InfoStaBase isb = new InfoStaBase();
			String[][] s = isb.InfoSearSta();
			SearchManyInfoStafPane smisp = new SearchManyInfoStafPane(s);
			smisp.pack();
			smisp.setVisible(true);
		}
		else if(obj==jmi3_4){
			InfoCarBase isb = new InfoCarBase();
			String[][] s = isb.InfoSearCar();
			SearchManyInfoCarPane smisp = new SearchManyInfoCarPane(s);
			smisp.pack();
			smisp.setVisible(true);
		}
		else if(obj==jmiuser_1){
			UserInf ui = new UserInf();
			ui.SearchInfoUserPane();
			ui.pack();
			ui.setVisible(true);
		}
		else if(obj==jmiuser_2){
			this.dispose();
			Land l = new Land();
			l.pack();
			l.setVisible(true);
		}
		else if(obj==jmiuser_3){
			InfoUserBase iub1 = new InfoUserBase();
			int a = iub1.InfoSearNum1(Suser);
			int dd = iub1.deleUserInf(a);
			JOptionPane.showMessageDialog(null, "删除成功","成功",JOptionPane.INFORMATION_MESSAGE);
			if(dd==1)
			{
				this.dispose();
				Land l = new Land();
				l.pack();
				l.setVisible(true);
			}		
		}
	}
}
