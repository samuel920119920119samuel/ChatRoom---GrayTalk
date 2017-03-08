package BallBall;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sun.media.jfxmedia.AudioClip;
import sun.audio.*;

public class Home extends JPanel implements ActionListener,MouseListener,MouseMotionListener{
	//private Canvas can= new Canvas();
	private Graphics hback;
	private Image hbuffer ; 
	private Image homebackground = new ImageIcon("homebackground.jpg").getImage();
	private Image be1 = new ImageIcon("be1.png").getImage();
	//private ImageIcon start =new ImageIcon("start.png");
	private Image start =new ImageIcon("start.png").getImage();
	private Image startbright =new ImageIcon("startBright.png").getImage();
	private Image pattern = new ImageIcon("pattern.png").getImage();
	private Image title = new ImageIcon("title.png").getImage();
	private int backx=0;
	
	private boolean startB=false;
	public boolean startclick=false;
	
	private Timer htimer = new Timer(50,this);
	public File file = new File("BGM000.WAV");
	boolean HMplay=true;
	//private JLabel startL = new JLabel();
	
	
	Home(){
		/*this.setLayout(null);
		startL.setIcon(start);
		startL.setBounds(0, 750, start.getIconWidth(), start.getIconHeight());
		startL.setOpaque(true);
		this.add(startL);*/
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		htimer.start();
		
	}
	
	public void update(Graphics g){
		hbuffer = createImage(Frame.FWidth,Frame.FHeight);
		hback = hbuffer.getGraphics();
		hback.drawImage(homebackground,backx,0,null);
		hback.drawImage(title,60,50,null);
		hback.drawImage(be1,-70,300,null);
		//hback.drawImage(startI,0,750,null);
		hback.drawImage(pattern,0,0,null);
		
		if(startB==false){
			hback.drawImage(start,0,750,null);
		}
		else if(startB==true){
			hback.drawImage(startbright,0,750,null);
		}
		
		g.drawImage(hbuffer, 0, 0, this);
	}
	public void paint(Graphics g){
		update(g);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		backx=backx-1;
		if(backx<=-413){
			backx=0;
		}
		repaint();
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1){
			if(e.getPoint().x>=0&&e.getPoint().x<=560&&e.getPoint().y>=750&&e.getPoint().y<=930){
				startclick=true;
				startB=false;
			}
		}
		
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent e2) {
	}
	public void mouseMoved(MouseEvent e2) {
		if(e2.getPoint().x>=0&&e2.getPoint().x<=560&&e2.getPoint().y>=750&&e2.getPoint().y<=930){
			startB=true;
		}
		else{
			startB=false;
		}
		
	}
	

}
