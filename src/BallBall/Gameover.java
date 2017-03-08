package BallBall;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameover extends JPanel implements ActionListener,MouseListener,MouseMotionListener{
	
	private Graphics GOback;
	private Image GObuffer ; 
	private Image GObackground = new ImageIcon("bg3.png").getImage();
	private Image IG =new ImageIcon("G.png").getImage();
	private Image IA =new ImageIcon("A.png").getImage();
	private Image IM =new ImageIcon("M.png").getImage();
	private Image IE1 =new ImageIcon("E.png").getImage();
	private Image IO =new ImageIcon("O.png").getImage();
	private Image IV =new ImageIcon("V.png").getImage();
	private Image IE2 =new ImageIcon("E.png").getImage();
	private Image IR =new ImageIcon("R.png").getImage();
	private Image bego1 =new ImageIcon("bego1.png").getImage();
	private Image bego2 =new ImageIcon("bego2.png").getImage();
	
	private Image again =new ImageIcon("GOagain.png").getImage();
	private Image home =new ImageIcon("GOhome.png").getImage();
	private Image againb =new ImageIcon("GOagainb.png").getImage();
	private Image homeb =new ImageIcon("GOhomeb.png").getImage();
	
	private boolean againbright = false;
	private boolean homebright = false;
	public boolean gameagain= false;
	public boolean backhome = false;
	
	int gy=-100,ay=-150,my=-130,e1y=-170;
	int oy,vy,e2y,ry=0;
	
	int bex=600,bey=200;
	
	boolean aa=false;
	boolean e1e1=false;
	boolean vv=false;
	boolean bechange=false;
	
	private Timer GOtimer = new Timer(50,this);
	
	static AudioPlayerM GOBGM;
	File BGMgameover = new File("BGMgameover.WAV");
	
	//53 46 68
	
	Gameover(){
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		GOtimer.start();
	}
	
	public void update(Graphics g){
		GObuffer = createImage(Frame.FWidth,Frame.FHeight);
		GOback = GObuffer.getGraphics();
		GOback.drawImage(GObackground,0,0,null);
		
		GOback.drawImage(IG,20,gy,null);
		GOback.drawImage(IA,120,ay,null);
		GOback.drawImage(IM,230,my,null);
		GOback.drawImage(IE1,340,e1y,null);
		GOback.drawImage(IO,120,oy,null);
		GOback.drawImage(IV,230,vy,null);
		GOback.drawImage(IE2,340,e2y,null);
		GOback.drawImage(IR,450,ry,null);
		
		if(bechange==false){
			GOback.drawImage(bego1,bex,bey,null);
		}
		else if(bechange==true){
			GOback.drawImage(bego2,bex,bey,null);
		}
		
		GOback.setFont(new Font("AR CENA",Font.BOLD,80));
		GOback.setColor(Color.WHITE);
		GOback.drawString("Your Score¡G"+Game.score, 40, 400);
		GOback.drawString("Top  Score¡G"+Game.topscore, 40, 500);
		
		if(againbright==false){
			GOback.drawImage(again,70,570,null);
		}
		else if(againbright==true){
			GOback.drawImage(againb,70,570,null);
		}
		
		if(homebright==false){
			GOback.drawImage(home,350,570,null);
		}
		else if(homebright==true){
			GOback.drawImage(homeb,350,570,null);
		}
		
		g.drawImage(GObuffer, 0, 0, this);
	}
	public void paint(Graphics g){
		update(g);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		//if(Frame.togameover==true){
			if(bex>50&&bey<700){
				bex=bex-10;
				bey=bey+10;
			}	
			else if (bechange==false){
				bechange=true;
			}
			
			if(bechange==true){
				if(bex>70){
					bex=bex-10;
				}
			}
			
			if(gy<50){
				gy=gy+10;
			}
			if(ay<=90&&aa==false){
				ay=ay+10;
				if(ay>=90){
					aa=true;
				}
			}
			if(aa==true){
				if(ay>50){
					ay=ay-5;
				}
			}
			if(my<50){
				my=my+10;
			}
			if(e1y<=100&&e1e1==false){
				e1y=e1y+10;
				if(e1y>=90){
					e1e1=true;
				}
			}
			if(e1e1==true){
				if(e1y>50){
					e1y=e1y-5;
				}
			}
			
			if(oy<180){
				oy=oy+15;
			}
			
			
			if(vy<=300&&vv==false){
				vy=vy+20;
				if(vy>=250){
					vv=true;
				}
			}
			if(vv==true){
				if(vy>180){
					vy=vy-10;
				}
			}
			
			
			if(e2y<180){
				e2y=e2y+8;
			}
			if(ry<180){
				ry=ry+10;
			}
			
		//}
		
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1){
			if(e.getPoint().x>=70&&e.getPoint().x<=70+again.getWidth(null)&&e.getPoint().y>=570&&e.getPoint().y<=570+again.getHeight(null)){
				gameagain=true;
				System.out.println("gameagain¡I");
			}
			
			if(e.getPoint().x>=350&&e.getPoint().x<=350+home.getWidth(null)&&e.getPoint().y>=570&&e.getPoint().y<=570+home.getHeight(null)){
				backhome=true;
			}
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	public void mouseDragged(MouseEvent e) {
	}
	public void mouseMoved(MouseEvent e) {	
		if(e.getPoint().x>=70&&e.getPoint().x<=70+again.getWidth(null)&&e.getPoint().y>=570&&e.getPoint().y<=570+again.getHeight(null)){
			againbright=true;
		}
		else{
			againbright=false;
		}
		
		if(e.getPoint().x>=350&&e.getPoint().x<=350+home.getWidth(null)&&e.getPoint().y>=570&&e.getPoint().y<=570+home.getHeight(null)){
			homebright=true;
		}
		else{
			homebright=false;
		}
	}

}
