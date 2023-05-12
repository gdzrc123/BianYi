package text01;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Language_Rules {
	
	JFrame frame=new JFrame("语法规则");
	
	String title[]= {"单词","巴克斯范式"};
	String data[][]=new String[][] {};
	DefaultTableModel dtm;
	JTable table;
	String not_MainString="";
	void init() {
		frame.setBounds((1500-1000)/2+50,(800-600)/2+50, 1000, 600);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setIconImage(new ImageIcon("src/data/image/语法规则图标.png").getImage());
		see_data();
	}
	void see_data() {
		dtm=new DefaultTableModel(data,title) {
			@Override
			public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		add_data();
	}
	void add_data() {
		table=new JTable(dtm);
		not_MainString="";
		not_MainString=new Way().Read_Data("src/data/语法规则表.txt");
		String arr[]=new String[2];
		String arr2[]=not_MainString.split(" ");
		for(int i=0;i<arr2.length/2;i++) {
			arr[0]=arr2[i*2];
			arr[1]=arr2[i*2+1];
			dtm.addRow(arr);			
			table.setModel(dtm);
		}
		JScrollPane jsp=new JScrollPane(table);
		frame.add(jsp);
	}
}