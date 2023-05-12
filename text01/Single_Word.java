package text01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Single_Word {
	JFrame frame=new JFrame("单字符分界符");
	
	JMenuBar menuBar;
	JMenuItem add_JMenuItem;
	JMenuItem change_JMenuItem;
	JMenuItem del_JMenuItem;	
	
	String[] title= {"ID","单分界符"};
	String[][]data=new String[][] {};
	DefaultTableModel dtm;
	JTable table;
	String NOT_main_string="";
	
	void init(){
		frame.setBounds((1500-500)/2+50, (800-400)/2+50, 500, 400);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("src/data/image/分界符图标.jpg").getImage());
		
		menuBar=new JMenuBar();

		//---------------菜单添加------------------------------
		add_JMenuItem=new JMenuItem("添加");
		menuBar.add(add_JMenuItem);		
		add_JMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Single_Word_add(frame, "添加", true, NOT_main_string).setVisible(true);
			}
		});
		//---------------菜单修改------------------------------		
		change_JMenuItem=new JMenuItem("修改");
		menuBar.add(change_JMenuItem);
		change_JMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Single_Word_change(frame, "修改", true, NOT_main_string).setVisible(true);
			}
		});
		//---------------菜单删除------------------------------		
		del_JMenuItem=new JMenuItem("删除");
		menuBar.add(del_JMenuItem);
		del_JMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Single_Word_del(frame, "删除", true, NOT_main_string).setVisible(true);
			}
		});
		
		frame.setJMenuBar(menuBar);
		see_data();
	}
	private void see_data() {
		dtm=new DefaultTableModel(data,title) {
			@Override
			public boolean isCellEditable(int hang,int lie) {
				return false;
			}
		};
		add_data();
	}
	private void add_data() {
		NOT_main_string="";
		table=new JTable(dtm);
		NOT_main_string=new Way().Read_Data("src/data/单字符分界符表.txt");
		String arr[]=new String[2];
		int ID;
		for(int i=0;i<NOT_main_string.length();i++) {
			ID=i+1;
			arr[0]=""+ID;
			arr[1]=""+NOT_main_string.charAt(i);
			dtm.addRow(arr);
			table.setModel(dtm);
		}
		JScrollPane jsp=new JScrollPane(table);
		frame.add(jsp);
	}
}