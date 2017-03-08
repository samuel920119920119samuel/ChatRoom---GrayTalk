package BallBall;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class select extends JPanel implements ActionListener,MouseListener {
	
	private ImageIcon b1 =new ImageIcon("bubble2(200).png");
	private ImageIcon b2 =new ImageIcon("ball2(200).png");
	private ImageIcon b3 =new ImageIcon("ball3(200).png");
	private ImageIcon b1B =new ImageIcon("bubble2B(200).png");
	private ImageIcon b2B =new ImageIcon("ball2B(200).png");
	private ImageIcon b3B =new ImageIcon("ball3B(200).png");
	JLabel ball1 = new JLabel();
	JLabel ball2 = new JLabel();
	JLabel ball3 = new JLabel();
	JLabel word = new JLabel();
	
	static int ballselect=0;
	public boolean selectover=false;
	
	static AudioPlayerM SBGM;
	File BGMselect = new File("BGMselect.WAV");
	
	select(){
		
	
		
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.setSize(568,1000);
		
		ball1.setIcon(b1);
		ball2.setIcon(b2);
		ball3.setIcon(b3);
		
		ball1.setBounds(180,250,b1.getIconWidth(),b1.getIconHeight());
		ball2.setBounds(50,550,b2.getIconWidth(),b2.getIconHeight());
		ball3.setBounds(300,550,b3.getIconWidth(),b3.getIconHeight());
		
		this.add(ball1);
		this.add(ball2);
		this.add(ball3);
		
		word.setForeground(Color.WHITE);
		word.setFont(new Font("AR DARLING",Font.BOLD,60));
		word.setText("Choose A BAll");
		word.setBounds(65, 50, 500, 100);
		
		this.add(word);
		
		ball1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				ballselect=1;
				selectover=true;
				System.out.println(ballselect);
			}
			public void mouseEntered(MouseEvent e){
				ball1.setIcon(b1B);
				
			}
			public void mouseExited(MouseEvent e) {
				ball1.setIcon(b1);
			}
		});
		
		ball2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				ballselect=2;
				selectover=true;
				System.out.println(ballselect);
			}
			public void mouseEntered(MouseEvent e){
				ball2.setIcon(b2B);
				
				
			}
			public void mouseExited(MouseEvent e) {
				ball2.setIcon(b2);
			}
		});
		
		ball3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				ballselect=3;
				selectover=true;
				System.out.println(ballselect);
			}
			public void mouseEntered(MouseEvent e){
				ball3.setIcon(b3B);
				
			}
			public void mouseExited(MouseEvent e) {
				ball3.setIcon(b3);
			}
		});
		
	}
	
	
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	public void actionPerformed(ActionEvent arg0) {
	}

}
