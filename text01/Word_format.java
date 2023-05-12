package text01;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Word_format {
	
	JFrame frame;
	
	String word_format_title[]= {"序号","分类","内容"};
	String data[][]=new String[][] {};
	DefaultTableModel dtm;
	JTable table;
	String not_MainString="";
	
	public void init() {
		frame=new JFrame("单词分类表");
		frame.setBounds((1500-400)/2+50,(800-300)/2+50, 400, 300);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("src/data/image/单词分类表图标.jpg").getImage());
		see_data();	
	}
	void see_data() {
		dtm = new DefaultTableModel(data, word_format_title) {
            //设置单元格不可编辑
            @Override
            public boolean isCellEditable(int hang , int lie) {
                return false;
            }
        };      
        add_data();
	}
	
	void add_data() {
		table=new JTable(dtm);  
		not_MainString="";
		not_MainString=new Way().Read_Data("src/data/单词分类表.txt");
		String []arr=new String[3];
		String arr2[]=not_MainString.split(" ");
		//System.out.println("获取的分类表内容个数"+arr2.length);
		for(int i=0;i<arr2.length/2;i++) {
			int id=i+1;
			arr[0]=""+id;
			arr[1]=""+arr2[i*2];
			arr[2]=""+arr2[i*2+1];
			dtm.addRow(arr);
			table.setModel(dtm);
		}
		JScrollPane jsp = new JScrollPane(table);
        frame.add(jsp);
	}
}
