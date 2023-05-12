package text01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Dialog_keyWord_add extends JDialog{
	public Dialog_keyWord_add(JFrame jf,String title,boolean isModel,String Yuan) {
		super(jf, title, isModel);
		this.setBounds((1500-200)/2+50, (800-150)/2+50, 200, 150);
		Box mainBox=Box.createVerticalBox();		
		Box nameBox=Box.createHorizontalBox();
		JLabel label=new JLabel("����:");
		nameBox.add(Box.createHorizontalStrut(20));
		nameBox.add(label);
		JTextField tf=new JTextField(1);
		mainBox.add(Box.createVerticalStrut(20));
		nameBox.add(Box.createHorizontalStrut(20));
		nameBox.add(tf);
		nameBox.add(Box.createHorizontalStrut(30));
		mainBox.add(nameBox);
		mainBox.add(Box.createVerticalStrut(20));

		//���
		Box btnBox=Box.createHorizontalBox();
		JButton button=new JButton("���");
		button.setBackground(new Color(255, 228, 196));
		button.setBorder(BorderFactory.createRaisedBevelBorder());
		btnBox.add(Box.createHorizontalStrut(30));
		btnBox.add(button);
		mainBox.add(btnBox);
		mainBox.add(Box.createVerticalStrut(20));
		this.add(mainBox);
		//�޸���ɫ
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String addString=tf.getText();
				//System.out.print("�ַ���Ҫ��ӵ�����"+addString);
				String change_String;
				if(addString.length()==0||addString==null){
					JOptionPane.showMessageDialog(jf, "���ʧ�ܣ�\nû������");
				}
				else if(new Way().ZiChuan_find(Yuan, addString)) {
					JOptionPane.showMessageDialog(jf, "���ʧ�ܣ�\n�ؼ������Ѵ�������");
				}
				else {
					String arr[]=new String[] {};
					change_String=Yuan+addString+",";								
					System.out.println("�ַ���ɹ���Ӻ������"+change_String);
					new Way().Wrtie_Data(change_String, "src/data/�ؼ��ֱ�.txt");
					JOptionPane.showMessageDialog(jf, "�ַ���\n���"+addString+"�ɹ���");
			        jf.setVisible(false);
				}
			}
		});
		
	}
}
