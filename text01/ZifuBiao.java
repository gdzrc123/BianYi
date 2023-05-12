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
	
	String[] zifu_title= {"ID","�ַ�"};
	String[][]data=new String[][] {};
	DefaultTableModel dtm;
	JTable table;
	String NOT_main_string="";
	
	void init() {		
		frame=new JFrame("�ַ���");
		frame.setBounds((1500-500)/2+50, (800-400)/2+50, 500, 400);
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("src/data/image/�ַ���ͼ��.jpg").getImage());		
		menuBar=new JMenuBar();
		
		//---------------�˵����------------------------------
		add_JMenuItem=new JMenuItem("���");
		menuBar.add(add_JMenuItem);		
		add_JMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Dialog_zifuBiao_add(frame,"���", true,NOT_main_string).setVisible(true);
			}
		});
		//---------------�˵��޸�------------------------------		
		change_JMenuItem=new JMenuItem("�޸�");
		menuBar.add(change_JMenuItem);
		change_JMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Dialog_zifuBiao_change(frame, "�޸�", true, NOT_main_string).setVisible(true);
			}
		});
		//---------------�˵�ɾ��------------------------------		
		del_JMenuItem=new JMenuItem("ɾ��");
		menuBar.add(del_JMenuItem);
		del_JMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Dialog_zifubiao_del(frame, "ɾ��", true, NOT_main_string).setVisible(true);
			}
		});
		
		frame.setJMenuBar(menuBar);
		see_data();		
	}	
	void see_data() {
		dtm = new DefaultTableModel(data, zifu_title) {
            //���õ�Ԫ�񲻿ɱ༭
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };      
        add_data();
	}	
	void add_data() {
		//bug ���⣬see_data()���ַ����ȡ�������ж��ѭ��,�ѽ��
		NOT_main_string="";
		//bug �����ÿ�ζ�ȡǰ������ʼ����Ĭ��Ϊ�գ������Ϊ�գ�����NOT_main_string+=line;�Ὣ��ʼ��seedata����
		table=new JTable(dtm);   
		NOT_main_string=new Way().Read_Data("src/data/�ַ���.txt");
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
