package text01;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Help {
	JFrame frame=new JFrame("����");
	void init(){
		frame.setBounds(400, 400, 500, 400);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("src/data/image/����ͼ��.jpg").getImage());
	}
}
