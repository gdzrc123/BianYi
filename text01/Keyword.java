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

public class Keyword {
	
	JFrame frame=new JFrame("关键字表");
	
	JMenuBar menuBar;
	JMenuItem addJMenuItem;
	JMenuItem changeJMenuItem;
	JMenuItem delJMenuItem;

	JTable table;
	DefaultTableModel dtm;
	String title[]= {"ID","关键字"};
	String data[][]=new String[][] {};
	String no_MainString="";
	void init() {
		frame.setBounds((1500-500)/2+50,(800-400)/2+50,500,400);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("src/data/image/关键字表图标.png").getImage());
		
		menuBar=new JMenuBar();
		addJMenuItem=new JMenuItem("添加");
		menuBar.add(addJMenuItem);
		addJMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Dialog_keyWord_add(frame, "添加",true, no_MainString).setVisible(true);
			}
		});
		
		changeJMenuItem=new JMenuItem("修改");
		menuBar.add(changeJMenuItem);
		changeJMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Dialog_keyWord_change(frame, "修改", true, no_MainString).setVisible(true);
			}
		});
		delJMenuItem=new JMenuItem("删除");
		menuBar.add(delJMenuItem);
		delJMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Dialog_keyWord_del(frame, "删除", true, no_MainString).setVisible(true);
			}
		});
		see_data();
		
		frame.setJMenuBar(menuBar);
	}
	void see_data() {
		dtm=new DefaultTableModel(data,title) {
			@Override
			public boolean isCellEditable(int hang,int lie) {
				return false;
			}
		};
		add_data();
	}
	void add_data() {
		table=new JTable();
		no_MainString=new Way().Read_Data("src/data/关键字表.txt");
		String arr2[]=no_MainString.split(",");
		String arr[]=new String[2] ;
		for(int i=0;i<arr2.length;i++) {
			int id=i+1;
			arr[0]=""+id;
			arr[1]=arr2[i];
			dtm.addRow(arr);
			table.setModel(dtm);
		}
		frame.add(table);
		JScrollPane jsp=new JScrollPane(table);
		frame.add(jsp);
	}
}
