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

public class Single_Word_change extends JDialog{
	public Single_Word_change(JFrame jf,String title,boolean isModeal,String not_main_String) {
		super(jf,title,isModeal);
		this.setBounds((1500-200)/2+50, (800-150)/2+50, 200, 150);
		
		Box vbox=Box.createVerticalBox();
		Box hBox=Box.createHorizontalBox();
		JLabel label=new JLabel("ID");
		TextField tf=new TextField(1);
		hBox.add(Box.createHorizontalStrut(35));
		hBox.add(label);
		hBox.add(Box.createHorizontalStrut(30));
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
		h2Box.add(Box.createHorizontalStrut(70));
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
				String zifu_String=tf2.getText();
				//System.out.println("Ҫ�޸ĵ�ID"+id_String);
				//System.out.println("�޸ĺ���ַ�"+zifu_String);
				if(id_String==null||id_String.length()==0) {
					JOptionPane.showMessageDialog(jf, "I�޸�ʧ�ܣ�\nID����û������");
				}
				else if(!new Way().isNumeric(id_String)){
					JOptionPane.showMessageDialog(jf,"�޸�ʧ�ܣ�\nID��Ϊ��������");
				}
				else {
					int ID=Integer.parseInt(id_String);
					if(ID<1||ID>not_main_String.length())
						JOptionPane.showMessageDialog(jf, "�޸�ʧ�ܣ�\nID������Χ");
					else if(zifu_String.length()==0){
						JOptionPane.showMessageDialog(jf, "�޸�ʧ��\n�޸ĺ���ַ����ݲ���Ϊ��");
					}
					else if(not_main_String.indexOf(zifu_String)!=-1) {//����ַ�
						JOptionPane.showMessageDialog(jf, "�޸�ʧ�ܣ�\n���ַ���ԭ�����Ѵ���");
					}
					else  if(zifu_String.length()>1){
						JOptionPane.showMessageDialog(jf, "�޸�ʧ��\n�޸ĺ���ַ�ֻ����1λ");
					}
					else {
						String op=""+not_main_String.charAt(ID-1);
						String content=not_main_String.replace(""+not_main_String.charAt(ID-1),zifu_String);
						//System.out.println("�滻���"+op);
						new Way().Wrtie_Data(content,"src/data/���ַ��ֽ����.txt");
						JOptionPane.showMessageDialog(jf, "�޸ĳɹ�\n"+"ԭ ID��"+ID+" �ַ���"+op+"\n"+"�� ID��"+ID+" �ַ���"+zifu_String);
						jf.setVisible(false);
					}
				}
			}
		});
	}
}
