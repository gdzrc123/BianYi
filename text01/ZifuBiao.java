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

public class ZifuBiao {
	
	JFrame frame;
	
	JMenuBar menuBar;
	JMenuItem add_JMenuItem;
	JMenuItem change_JMenuItem;
	JMenuItem del_JMenuItem;	
	
	String[] zifu_title= {"ID","字符"};
	String[][]data=new String[][] {};
	DefaultTableModel dtm;
	JTable table;
	String NOT_main_string="";
	
	void init() {		
		frame=new JFrame("字符表");
		frame.setBounds((1500-500)/2+50, (800-400)/2+50, 500, 400);
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("src/data/image/字符表图标.jpg").getImage());		
		menuBar=new JMenuBar();
		
		//---------------菜单添加------------------------------
		add_JMenuItem=new JMenuItem("添加");
		menuBar.add(add_JMenuItem);		
		add_JMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Dialog_zifuBiao_add(frame,"添加", true,NOT_main_string).setVisible(true);
			}
		});
		//---------------菜单修改------------------------------		
		change_JMenuItem=new JMenuItem("修改");
		menuBar.add(change_JMenuItem);
		change_JMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Dialog_zifuBiao_change(frame, "修改", true, NOT_main_string).setVisible(true);
			}
		});
		//---------------菜单删除------------------------------		
		del_JMenuItem=new JMenuItem("删除");
		menuBar.add(del_JMenuItem);
		del_JMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Dialog_zifubiao_del(frame, "删除", true, NOT_main_string).setVisible(true);
			}
		});
		
		frame.setJMenuBar(menuBar);
		see_data();		
	}	
	void see_data() {
		dtm = new DefaultTableModel(data, zifu_title) {
            //设置单元格不可编辑
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };      
        add_data();
	}	
	void add_data() {
		//bug 问题，see_data()从字符表读取的数据有多次循环,已解决
		NOT_main_string="";
		//bug 解决，每次读取前都将初始数据默认为空，如果不为空，进行NOT_main_string+=line;会将初始的seedata加入
		table=new JTable(dtm);   
		NOT_main_string=new Way().Read_Data("src/data/字符表.txt");
		String []arr=new String[2];
		for(int i=0;i<NOT_main_string.length();i++) {
			int id=i+1;
			arr[0]=""+id;
			arr[1]=""+NOT_main_string.charAt(i);
			dtm.addRow(arr);
			table.setModel(dtm);
		}
		JScrollPane jsp = new JScrollPane(table);
        frame.add(jsp);
	}
}
