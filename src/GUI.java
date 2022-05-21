import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame {
	GUI() throws InterruptedException {
		setTitle("Horse Race!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel spade = new JLabel("¢¼");
		spade.setBounds(0, 50, 50, 100);
		add(spade);
		
		setSize(400, 400);
		setVisible(true);
		
		for (int i = 0; i < 7; i++) {
			spade.setBounds(0 + 50 * i, 50, 50 + 50 * i, 100);
			Thread.sleep(1000);
		}
	}
}
