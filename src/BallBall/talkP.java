package BallBall;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class talkP {

	private JFrame frame;
	public JPanel TP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					talkP window = new talkP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public talkP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 568, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TP = new JPanel();
		TP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
		});
		TP.setBounds(0, 0, 568, 1000);
		frame.getContentPane().add(TP);
		TP.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\\u5927\u5B78\\\u8A08\u5BE6104\u4E0B\\final project\\talk.png"));
		lblNewLabel_1.setBounds(0, 693, 554, 250);
		TP.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("AR CENA", Font.BOLD, 39));
		lblNewLabel.setIcon(new ImageIcon("D:\\\u5927\u5B78\\\u8A08\u5BE6104\u4E0B\\final project\\bet1.png"));
		lblNewLabel.setBounds(50, 368, 400, 372);
		TP.add(lblNewLabel);
	}
}
