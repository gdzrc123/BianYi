package text01;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainDesk {
	JFrame frame;
	JMenuBar menuBar;
	
	JMenu oSMaintenanceMenu;
	JMenuItem ziFu_BiaoItem;
	JMenuItem word_FormatItem;
	JMenuItem language_RuleItem;
	
	JMenu cifa_analyiseJMenu;
	JMenuItem keyword_JMenuItem;
	JMenuItem singleword_JMenuItem;
	JMenuItem DFA_JMenuItem;
	JMenuItem process_exhabitJMenuItem;
	
	JMenu helpJMenu;
	JMenuItem helpItem;
	
	void init() {
		//----------------
		//窗口大小
		//------------------
		frame=new JFrame("喵星人科技公司");
		frame.setBounds((1500-900)/2+50, (800-650)/2+50, 900, 650);
		frame.setVisible(true);
		ImageIcon img=new ImageIcon("src/data/image/主界面背景.jpg");
		JLabel label=new JLabel(img);
		label.setBounds(0, 0, frame.getWidth(),frame.getHeight());
		JPanel imageJPanel=(JPanel)frame.getContentPane();
		imageJPanel.setOpaque(false);
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		frame.setIconImage(new ImageIcon("src/data/image/主图标.png").getImage());
		
		//点击x退出程序
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		//----------------
		//系统维护菜单
		//------------------
		menuBar=new JMenuBar();
		menuBar.setPreferredSize(new Dimension(frame.getWidth(),20));
		oSMaintenanceMenu=new JMenu("系统维护");
		oSMaintenanceMenu.setPreferredSize(new Dimension(frame.getWidth()/3,20));
		ziFu_BiaoItem=new JMenuItem("字符表");
		oSMaintenanceMenu.add(ziFu_BiaoItem);
		oSMaintenanceMenu.addSeparator();
		ziFu_BiaoItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ZifuBiao().init();
			}
		});
		word_FormatItem=new JMenuItem("单词分类");
		oSMaintenanceMenu.add(word_FormatItem);
		oSMaintenanceMenu.addSeparator();
		word_FormatItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Word_format().init();
			}
		});
		language_RuleItem=new JMenuItem("语法规则");
		oSMaintenanceMenu.add(language_RuleItem);
		language_RuleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Language_Rules().init();
			}
		});
		menuBar.add(oSMaintenanceMenu);
		
		//----------------
		//词法分析菜单
		//------------------
		cifa_analyiseJMenu=new JMenu("词法分析");
		cifa_analyiseJMenu.setPreferredSize(new Dimension(frame.getWidth()/3,20));
		keyword_JMenuItem=new JMenuItem("关键字表");
		cifa_analyiseJMenu.add(keyword_JMenuItem);
		cifa_analyiseJMenu.addSeparator();
		keyword_JMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Keyword().init();
			}
		});
		singleword_JMenuItem=new JMenuItem("单字符分界符");
		cifa_analyiseJMenu.add(singleword_JMenuItem);
		cifa_analyiseJMenu.addSeparator();
		singleword_JMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Single_Word().init();
			}
		});
		DFA_JMenuItem=new JMenuItem("DFA");
		cifa_analyiseJMenu.add(DFA_JMenuItem);
		cifa_analyiseJMenu.addSeparator();
		DFA_JMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Cifa_analyise().init();
			}
		});
		process_exhabitJMenuItem=new JMenuItem("过程展示");
		cifa_analyiseJMenu.add(process_exhabitJMenuItem);
		process_exhabitJMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Process_exhabit().init();
			}
		});
		menuBar.add(cifa_analyiseJMenu);
		
		//----------------
		//帮助菜单
		//------------------
		helpJMenu=new JMenu("帮助");
		helpJMenu.setPreferredSize(new Dimension(frame.getWidth()/3,20));
		helpItem=new JMenuItem("文档");
		helpJMenu.add(helpItem);
		menuBar.add(helpJMenu);
		helpItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Help().init();
			}
		});
		frame.setJMenuBar(menuBar);
	}
}
