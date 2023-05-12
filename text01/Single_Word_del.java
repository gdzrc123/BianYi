package text01;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Single_Word_del extends JDialog{
	public Single_Word_del(JFrame jf,String title,boolean isModeal,String NOT_main_string) {
		super(jf,title,isModeal);
		this.setBounds((1500-200)/2+50, (800-150)/2+50, 200, 150);
		
		Box vbox=Box.createVerticalBox();
		Box hbox=Box.createHorizontalBox();
		JLabel label=new JLabel("ID");
		hbox.add(Box.createHorizontalStrut(35));
		hbox.add(label);
		hbox.add(Box.createHorizontalStrut(30));
		TextField tf=new TextField(1);
		hbox.add(tf);
		hbox.add(Box.createHorizontalStrut(70));
		vbox.add(Box.createVerticalStrut(25));
		vbox.add(hbox);
		vbox.add(Box.createHorizontalStrut(10));
		vbox.add(Box.createVerticalStrut(20));
		
		Box pbox=Box.createHorizontalBox();
		JButton button=new JButton("删除ID");
		button.setBackground(new Color(255, 228, 196));
		button.setBorder(BorderFactory.createRaisedBevelBorder());
		pbox.add(Box.createHorizontalStrut(5));
		pbox.add(button);
		vbox.add(pbox);
		vbox.add(Box.createVerticalStrut(20));
		
		this.add(vbox);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String del_String=tf.getText();
				//System.out.println("字符表要删除的字符"+del_String);
				if(del_String.length()==0||del_String==null) {
					JOptionPane.showMessageDialog(jf,"删除失败！\n没有数据");
				}
				else if(!new Way().isNumeric(del_String)) {
					JOptionPane.showMessageDialog(jf,"删除失败！\n删除内容不为数字类型");
				}
				else {
					int ID=Integer.parseInt(del_String);
					if(ID<1||ID>NOT_main_string.length()) {
						JOptionPane.showMessageDialog(jf, "删除失败！\nID超出范围");
					}
					else{
						JOptionPane.showMessageDialog(jf, "删除ID："+ID+"成功");
						String del_afterString=del(NOT_main_string,ID-1);
						new Way().Wrtie_Data(del_afterString,"src/data/单字符分界符表.txt");
						System.out.println("删除后的字符串-----"+del_afterString+"--------");						
						jf.setVisible(false);
					}
				}				
			}

		});
	}
	
	//删除指定位置字符，并返回删除后的新数据
	private String del (String Yuan,int index) {
		String DEL_after="";
			//DEL_after=DEL_after+Yuan.substring(1);//sub似乎有问题重写吧如果加入的第一个数据 是空格那不会加进去
			//DEL_after=DEL_after+Yuan.substring(0, index-1)+Yuan.substring(index+1);
			for(int i=0;i<=index-1;i++) {
				DEL_after+=Yuan.charAt(i);
			}
			for(int i=index+1;i<Yuan.length();i++) {
				DEL_after+=Yuan.charAt(i);
			}
		return DEL_after;
	}
}
