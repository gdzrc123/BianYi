package text01;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Process_exhabit {
	JFrame frame=new JFrame("词法分析过程展示");
	void init(){
		frame.setBounds(400, 400, 500, 400);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setIconImage(new ImageIcon("src/data/image/DFA图标.jpg").getImage());
		ImageIcon img=new ImageIcon("src/data/image/DFA背景.jpg");
		JLabel label=new JLabel(img);
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		JPanel imageJPanel=(JPanel)frame.getContentPane();
		imageJPanel.setOpaque(false);
		frame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
	}
}
