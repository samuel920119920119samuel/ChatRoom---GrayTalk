package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JEditorPane;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Client_room_GUI {
	public static JPanel room ;
	public JButton game;
	public static JTextField input;
	public static JTextArea output;
	private JScrollPane scrollPane;
	public JButton emoticon;
	JFrame frame;
	JLabel chatName;
	JLabel chatIP;
	JButton save;
	JLabel state;
	private JPanel panel;
	
	
	/**
	 * Launch the application.
	 */
	/* thread
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frame.setVisile(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 */
	public Client_room_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("GrayTalk");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("GTitle.png"));
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 320, 670);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		room = new JPanel();
		room.setBackground(Color.DARK_GRAY);
		room.setLayout(null);
		frame.getContentPane().add(room);
		
		chatName = new JLabel("");
		chatName.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		chatName.setEnabled(true);
		chatName.setForeground(new Color(255, 228, 196));
		chatName.setBounds(10, 0, 147, 40);
		room.add(chatName);
		
		chatIP = new JLabel("");
		chatIP.setHorizontalAlignment(SwingConstants.RIGHT);
		chatIP.setVerticalAlignment(SwingConstants.BOTTOM);
		chatIP.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		chatIP.setForeground(new Color(255, 228, 196));
		chatIP.setBounds(167, 0, 137, 40);
		room.add(chatIP);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 40, 314, 483);
		room.add(scrollPane);
		
		output = new JTextArea();
		scrollPane.setViewportView(output);
		output.setForeground(Color.WHITE);
		output.setEditable(false);
		output.setWrapStyleWord(true);
		output.setLineWrap(true);
		output.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		output.setBackground(Color.DARK_GRAY);
		
		state = new JLabel("");
		state.setDisplayedMnemonic('f');
		state.setHorizontalAlignment(SwingConstants.RIGHT);
		state.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		state.setBackground(Color.DARK_GRAY);
		state.setForeground(new Color(255, 228, 196));
		state.setBounds(167, 523, 137, 36);
		room.add(state);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(255, 228, 196), 3));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 523, 314, 36);
		room.add(panel);
		panel.setLayout(null);
		
		emoticon = new JButton("");
		emoticon.setBounds(10, 7, 22, 22);
		panel.add(emoticon);
		emoticon.setIcon(new ImageIcon("emoticon.png"));
		emoticon.setToolTipText("");
		emoticon.setBackground(Color.DARK_GRAY);
		emoticon.setForeground(new Color(255, 228, 196));
		
		game = new JButton("");
		game.setBounds(39, 7, 22, 22);
		panel.add(game);
		game.setIcon(new ImageIcon("game.png"));
		game.setToolTipText("");
		game.setForeground(new Color(255, 228, 196));
		game.setBackground(Color.DARK_GRAY);
		game.addActionListener((ActionListener) this);
		
		save = new JButton("");
		save.setBounds(68, 7, 22, 22);
		panel.add(save);
		save.setIcon(new ImageIcon("save.png"));
		save.setToolTipText("");
		save.setForeground(new Color(255, 228, 196));
		save.setBackground(Color.DARK_GRAY);
		
		input = new JTextField();
		input.setHorizontalAlignment(SwingConstants.LEFT);
		input.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		input.setBackground(Color.DARK_GRAY);
		input.setForeground(Color.WHITE);
		input.setBounds(0, 558, 314, 83);
		room.add(input);
		input.setColumns(10);
	}
}
