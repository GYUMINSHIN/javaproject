import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame {
	Font font = new Font("¸¼Àº °íµñ", Font.PLAIN, 25);
	String colNames[] = {"Start", " ", " ", " ", " ", " ", " ", "Goal"};
	Object datas[][] =
			{
					{ '¢¼', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ '¡ß', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ '¢¾', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
					{ '¢À', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
			};
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JTable table = new JTable(datas, colNames);
	JScrollPane jscp = new JScrollPane(table);
	JLabel label = new JLabel("»ÌÀº Ä«µå: ");
	JLabel cardLabel = new JLabel("Å×½ºÆ®");
	
	GUI() {
		super("Horse Race!");
		this.setLocation(0, 0);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		table.setFont(font);
		table.setRowHeight(50);
		label.setFont(font);
		cardLabel.setFont(font);
		
		panel1.add(jscp);
		panel2.add(label);
		panel2.add(cardLabel);
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.PAGE_END);
		
		this.pack();
		this.setVisible(true);
	}
	
	public void showCard(Card card) throws InterruptedException {
		cardLabel.setText(card.toString());
		System.out.println(card.toString());
		cardLabel.repaint();
		Thread.sleep(1000);
	}
	
	public void updateScreen(int symbol, int curPosition, int movePosition) {
		datas[symbol][movePosition] = datas[symbol][curPosition];
		if (curPosition != movePosition)
		{
			datas[symbol][curPosition] = ' ';
		}
		table.repaint();
	}
}
