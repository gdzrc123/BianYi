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
		JButton button=new JButton("ɾ��ID");
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
				//System.out.println("�ַ���Ҫɾ�����ַ�"+del_String);
				if(del_String.length()==0||del_String==null) {
					JOptionPane.showMessageDialog(jf,"ɾ��ʧ�ܣ�\nû������");
				}
				else if(!new Way().isNumeric(del_String)) {
					JOptionPane.showMessageDialog(jf,"ɾ��ʧ�ܣ�\nɾ�����ݲ�Ϊ��������");
				}
				else {
					int ID=Integer.parseInt(del_String);
					if(ID<1||ID>NOT_main_string.length()) {
						JOptionPane.showMessageDialog(jf, "ɾ��ʧ�ܣ�\nID������Χ");
					}
					else{
						JOptionPane.showMessageDialog(jf, "ɾ��ID��"+ID+"�ɹ�");
						String del_afterString=del(NOT_main_string,ID-1);
						new Way().Wrtie_Data(del_afterString,"src/data/���ַ��ֽ����.txt");
						System.out.println("ɾ������ַ���-----"+del_afterString+"--------");						
						jf.setVisible(false);
					}
				}				
			}

		});
	}
	
	//ɾ��ָ��λ���ַ���������ɾ�����������
	private String del (String Yuan,int index) {
		String DEL_after="";
			//DEL_after=DEL_after+Yuan.substring(1);//sub�ƺ���������д���������ĵ�һ������ �ǿո��ǲ���ӽ�ȥ
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
