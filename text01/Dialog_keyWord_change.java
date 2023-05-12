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

public class Dialog_keyWord_change extends JDialog{
	public Dialog_keyWord_change(JFrame jf,String title,boolean isModeal,String Yuan) {
		super(jf,title,isModeal);
		this.setBounds((1500-200)/2+50, (800-150)/2+50, 200, 150);
		
		Box vbox=Box.createVerticalBox();
		Box hBox=Box.createHorizontalBox();
		JLabel label=new JLabel("ID");
		TextField tf=new TextField(1);
		hBox.add(Box.createHorizontalStrut(40));
		hBox.add(label);
		hBox.add(Box.createHorizontalStrut(45));
		hBox.add(tf);
		hBox.add(Box.createHorizontalStrut(70));
		vbox.add(Box.createVerticalStrut(15));
		vbox.add(hBox);
		Box h2Box=Box.createHorizontalBox();
		JLabel label2=new JLabel("�ĺ��ַ�");
		TextField tf2=new TextField(1);
		h2Box.add(Box.createHorizontalStrut(15));
		h2Box.add(label2);
		h2Box.add(Box.createHorizontalStrut(10));
		h2Box.add(tf2);		
		h2Box.add(Box.createHorizontalStrut(40));
		vbox.add(Box.createVerticalStrut(10));
		vbox.add(h2Box);
		JButton button=new JButton("�޸�");
		Box h3Box=Box.createHorizontalBox();
		button.setBorder(BorderFactory.createRaisedBevelBorder());
		button.setBackground(new Color(255, 228, 196));
		h3Box.add(button);
		vbox.add(Box.createVerticalStrut(10));
		vbox.add(h3Box);
		vbox.add(Box.createVerticalStrut(10));
		this.add(vbox);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id_String=tf.getText();
				String change_String=tf2.getText();
				String arr[]=Yuan.split(",");
				if(id_String==null||id_String.length()==0) {
					JOptionPane.showMessageDialog(jf, "I�޸�ʧ�ܣ�\nID����û������");
				}
				else if(!new Way().isNumeric(id_String)){
					JOptionPane.showMessageDialog(jf,"�޸�ʧ�ܣ�\nID��Ϊ��������");
				}
				else {
					int ID=Integer.parseInt(id_String);
					if(ID<1||ID>arr.length)
						JOptionPane.showMessageDialog(jf, "�޸�ʧ�ܣ�\nID������Χ");
					else if(change_String.length()==0){
						JOptionPane.showMessageDialog(jf, "�޸�ʧ��\n�޸ĺ���ַ������ݲ���Ϊ��");
					}
					else if(new Way().ZiChuan_find(Yuan, change_String)) {//����ַ�
						JOptionPane.showMessageDialog(jf, "�޸�ʧ�ܣ�\n���ַ�����ԭ�����Ѵ���");
					}
					else {
						String op=arr[ID-1];
						String content=Yuan.replace(""+op,change_String);
						//System.out.println("�滻���"+op);
						new Way().Wrtie_Data(content,"src/data/�ؼ��ֱ�.txt");
						JOptionPane.showMessageDialog(jf, "�޸ĳɹ�\n"+"ԭ ID��"+ID+" �ַ�����"+op+"\n"+"�� ID��"+ID+" �ַ�����"+change_String);
						jf.setVisible(false);
					}
				}
			}
		});
	}
}
