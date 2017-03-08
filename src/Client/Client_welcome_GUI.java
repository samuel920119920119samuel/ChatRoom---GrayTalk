package Client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Client_welcome_GUI {

	JFrame frame;
	public JButton sendButton;
	public JLabel lb_state;
	public JTextField tp_nickname;
	public JLabel lb_nickname;
	public JTextField tp_id ;
	public JLabel lb_id;
	public JPanel welcome ;
	JLabel GSlogan;
	JLabel GIcon;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGUI window = new ClientGUI();
					window.frame.setVisible(true);
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
	public Client_welcome_GUI() {
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		welcome = new JPanel();
		welcome.setBackground(Color.DARK_GRAY);
		welcome.setLayout(null);
		frame.getContentPane().add(welcome);
		
		
		GIcon = new JLabel("");
		GIcon.setIcon(new ImageIcon("GIcon.png"));
		GIcon.setBounds(90, 60, 125, 125);
		welcome.add(GIcon);
		
		GSlogan = new JLabel("");
		GSlogan.setIcon(new ImageIcon("GSlogan.png"));
		GSlogan.setBounds(50, 210, 200, 80);
		welcome.add(GSlogan);
		
		lb_id = new JLabel("IP :");
		lb_id.setBackground(Color.DARK_GRAY);
		lb_id.setHorizontalAlignment(SwingConstants.CENTER);
		lb_id.setForeground(Color.CYAN);
		lb_id.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		lb_id.setBounds(25, 415, 92, 26);
		welcome.add(lb_id);
		
		tp_id = new JTextField();
		tp_id.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		tp_id.setBounds(127, 417, 140, 26);
		welcome.add(tp_id);
		tp_id.setBackground(Color.GRAY);
		tp_id.setForeground(Color.WHITE);
		
		lb_nickname = new JLabel("Nickname :");
		lb_nickname.setBackground(Color.DARK_GRAY);
		lb_nickname.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		lb_nickname.setHorizontalAlignment(SwingConstants.CENTER);
		lb_nickname.setForeground(new Color(0, 255, 255));
		lb_nickname.setBounds(25, 451, 92, 26);
		welcome.add(lb_nickname);
		
		tp_nickname = new JTextField();
		tp_nickname.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		tp_nickname.setForeground(Color.WHITE);
		tp_nickname.setBackground(Color.GRAY);
		tp_nickname.setBounds(127, 451, 140, 26);
		welcome.add(tp_nickname);
		
		sendButton = new JButton("Chat !");
		sendButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		sendButton.setBounds(98, 506, 100, 40);
		welcome.add(sendButton);
		
		
		lb_state = new JLabel("");
		lb_state.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lb_state.setForeground(Color.WHITE);
		lb_state.setHorizontalAlignment(SwingConstants.CENTER);
		lb_state.setBounds(79, 558, 135, 26);
		welcome.add(lb_state);
	}
}
