import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame {
	Font font = new Font("¸¼Àº °íµñ", Font.PLAIN, 25);
	JLabel[] labels = new JLabel[4];
	
	GUI() throws InterruptedException {
		setTitle("Horse Race!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 450);
		setLayout(null);
		
		labels[0] = new JLabel("¢¼");
		labels[1] = new JLabel("¡ß");
		labels[2] = new JLabel("¢¾");
		labels[3] = new JLabel("¢À");
		
		labels[1].setForeground(Color.red);
		labels[2].setForeground(Color.red);
		
		for (int i = 0; i < 4; i++) {
			labels[i].setFont(font);
			labels[i].setBounds(0, 90 + 60 * i, 30, 30);
			add(labels[i]);
		}
		
		setVisible(true);
	}
	
	void updateScreen(int symbol, int position) throws InterruptedException {
		labels[symbol].setBounds(0 + 55 * position, 90 + 60 * symbol, 30, 30);
		Thread.sleep(1000);
	}
}
