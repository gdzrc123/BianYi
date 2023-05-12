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

public class Dialog_keyWord_del extends JDialog{
	public Dialog_keyWord_del(JFrame jf,String title,boolean isModel,String Yuan) {
		super(jf,title,isModel);
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
		JButton button=new JButton("É¾³ýID");
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
				String arr[]=Yuan.split(",");
				if(del_String.length()==0||del_String==null) {
					JOptionPane.showMessageDialog(jf,"É¾³ýÊ§°Ü£¡\nÃ»ÓÐÊý¾Ý");
				}
				else if(!new Way().isNumeric(del_String)) {
					JOptionPane.showMessageDialog(jf,"É¾³ýÊ§°Ü£¡\nÉ¾³ýÄÚÈÝ²»ÎªÊý×ÖÀàÐÍ");
				}
				else {
					int ID=Integer.parseInt(del_String);
					if(ID<1||ID>arr.length) {
						JOptionPane.showMessageDialog(jf, "É¾³ýÊ§°Ü£¡\nID³¬³ö·¶Î§");
					}
					else{
						JOptionPane.showMessageDialog(jf, "É¾³ýID£º"+ID+"³É¹¦");
						String del_afterString=del(Yuan,ID-1);
						new Way().Wrtie_Data(del_afterString,"src/data/¹Ø¼ü×Ö±í.txt");
						System.out.println("É¾³ýºóµÄ×Ö·û´®-----"+del_afterString+"--------");						
						jf.setVisible(false);
					}
				}			
			}
		});
	}
	private String del(String Yuan,int index) {
		String after_String="";
		String arr[]=Yuan.split(",");
		for(int i=0;i<Yuan.indexOf(arr[index]);i++) {
			after_String+=Yuan.charAt(i);
		}
		for(int i=Yuan.indexOf(arr[index])+arr[index].length()+1;i<Yuan.length();i++) {
			after_String+=Yuan.charAt(i);
		}
		return after_String;
	}
}
