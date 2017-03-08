package Client;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class Client_emoticon_GUI {

	JFrame frame;
	JScrollPane scrollPane_sticker;
	JButton sticker1;
	JButton sti1_but1,sti1_but2,sti1_but3,
			sti1_but4,sti1_but5,sti1_but6,
			sti1_but7,sti1_but8,sti1_but9,
			sti1_but10,sti1_but11,sti1_but12,
			sti1_but13,sti1_but14,sti1_but15;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client_emoticon_GUI window = new Client_emoticon_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the application.
	 */
	public Client_emoticon_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 354, 120);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		sticker1 = new JButton("(^-^)");
		sticker1.setBounds(15, 15, 60, 30);
		panel.add(sticker1);
		
		scrollPane_sticker = new JScrollPane();
		scrollPane_sticker.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_sticker.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_sticker.setBounds(0, 120, 354, 236);
		scrollPane_sticker.setVisible(false);
		frame.getContentPane().add(scrollPane_sticker);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		scrollPane_sticker.setColumnHeaderView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{95, 33, 101, 33, 115, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0, 33, 0, 0, 0, 23, 33, 0, 23, 31, 23, 31, 23, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		sti1_but1 = new JButton("(^-^)");
		GridBagConstraints gbc_sti1_but1 = new GridBagConstraints();
		gbc_sti1_but1.fill = GridBagConstraints.BOTH;
		gbc_sti1_but1.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but1.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but1.gridx = 0;
		gbc_sti1_but1.gridy = 1;
		panel_1.add(sti1_but1, gbc_sti1_but1);
		
		sti1_but2 = new JButton("(^y^)");
		GridBagConstraints gbc_sti1_but2 = new GridBagConstraints();
		gbc_sti1_but2.fill = GridBagConstraints.BOTH;
		gbc_sti1_but2.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but2.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but2.gridx = 1;
		gbc_sti1_but2.gridy = 1;
		panel_1.add(sti1_but2, gbc_sti1_but2);
		
		sti1_but3 = new JButton("p(^-^q)");
		GridBagConstraints gbc_sti1_but3 = new GridBagConstraints();
		gbc_sti1_but3.fill = GridBagConstraints.BOTH;
		gbc_sti1_but3.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but3.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but3.gridx = 2;
		gbc_sti1_but3.gridy = 1;
		panel_1.add(sti1_but3, gbc_sti1_but3);
		
		sti1_but4 = new JButton("(=m=)");
		GridBagConstraints gbc_sti1_but4 = new GridBagConstraints();
		gbc_sti1_but4.fill = GridBagConstraints.BOTH;
		gbc_sti1_but4.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but4.gridx = 0;
		gbc_sti1_but4.gridy = 2;
		panel_1.add(sti1_but4, gbc_sti1_but4);
		
		sti1_but5 = new JButton("(\u30FB\u03C9\u30FB)");
		GridBagConstraints gbc_sti1_but5 = new GridBagConstraints();
		gbc_sti1_but5.fill = GridBagConstraints.BOTH;
		gbc_sti1_but5.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but5.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but5.gridx = 1;
		gbc_sti1_but5.gridy = 2;
		panel_1.add(sti1_but5, gbc_sti1_but5);
		
		sti1_but6 = new JButton("(\u02CB\u0410\u02CA)");
		GridBagConstraints gbc_sti1_but6 = new GridBagConstraints();
		gbc_sti1_but6.fill = GridBagConstraints.BOTH;
		gbc_sti1_but6.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but6.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but6.gridx = 2;
		gbc_sti1_but6.gridy = 2;
		panel_1.add(sti1_but6, gbc_sti1_but6);
		
		sti1_but7 = new JButton("(>\u03C9<)");
		GridBagConstraints gbc_sti1_but7 = new GridBagConstraints();
		gbc_sti1_but7.fill = GridBagConstraints.BOTH;
		gbc_sti1_but7.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but7.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but7.gridx = 0;
		gbc_sti1_but7.gridy = 3;
		panel_1.add(sti1_but7, gbc_sti1_but7);
		
		sti1_but8 = new JButton("(T-T)");
		GridBagConstraints gbc_sti1_but8 = new GridBagConstraints();
		gbc_sti1_but8.fill = GridBagConstraints.BOTH;
		gbc_sti1_but8.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but8.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but8.gridx = 1;
		gbc_sti1_but8.gridy = 3;
		panel_1.add(sti1_but8, gbc_sti1_but8);
		
		sti1_but9 = new JButton("(^o^)");
		sti1_but9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_sti1_but9 = new GridBagConstraints();
		gbc_sti1_but9.fill = GridBagConstraints.BOTH;
		gbc_sti1_but9.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but9.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but9.gridx = 2;
		gbc_sti1_but9.gridy = 3;
		panel_1.add(sti1_but9, gbc_sti1_but9);
		
		sti1_but10 = new JButton("(0_0)");
		GridBagConstraints gbc_sti1_but10 = new GridBagConstraints();
		gbc_sti1_but10.fill = GridBagConstraints.BOTH;
		gbc_sti1_but10.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but10.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but10.gridx = 0;
		gbc_sti1_but10.gridy = 4;
		panel_1.add(sti1_but10, gbc_sti1_but10);
		
		sti1_but11 = new JButton("(*\u0437*)");
		GridBagConstraints gbc_sti1_but11 = new GridBagConstraints();
		gbc_sti1_but11.fill = GridBagConstraints.BOTH;
		gbc_sti1_but11.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but11.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but11.gridx = 1;
		gbc_sti1_but11.gridy = 4;
		panel_1.add(sti1_but11, gbc_sti1_but11);
		
		sti1_but12 = new JButton("<3");
		GridBagConstraints gbc_sti1_but12 = new GridBagConstraints();
		gbc_sti1_but12.fill = GridBagConstraints.BOTH;
		gbc_sti1_but12.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but12.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but12.gridx = 2;
		gbc_sti1_but12.gridy = 4;
		panel_1.add(sti1_but12, gbc_sti1_but12);
		
		sti1_but13 = new JButton("('\u03C9\u00B4' )");
		GridBagConstraints gbc_sti1_but13 = new GridBagConstraints();
		gbc_sti1_but13.fill = GridBagConstraints.BOTH;
		gbc_sti1_but13.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but13.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but13.gridx = 0;
		gbc_sti1_but13.gridy = 5;
		panel_1.add(sti1_but13, gbc_sti1_but13);
		
		sti1_but14 = new JButton("< (- v -)>");
		GridBagConstraints gbc_sti1_but14 = new GridBagConstraints();
		gbc_sti1_but14.fill = GridBagConstraints.BOTH;
		gbc_sti1_but14.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but14.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but14.gridx = 1;
		gbc_sti1_but14.gridy = 5;
		panel_1.add(sti1_but14, gbc_sti1_but14);
		
		sti1_but15 = new JButton("\u03A3(0L_ 0)");
		GridBagConstraints gbc_sti1_but15 = new GridBagConstraints();
		gbc_sti1_but15.fill = GridBagConstraints.BOTH;
		gbc_sti1_but15.insets = new Insets(0, 0, 5, 5);
		gbc_sti1_but15.anchor = GridBagConstraints.NORTHWEST;
		gbc_sti1_but15.gridx = 2;
		gbc_sti1_but15.gridy = 5;
		panel_1.add(sti1_but15, gbc_sti1_but15);
		
		frame.setBounds(100, 100, 360, 385);
		//防止連聊天室也一起關掉
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
