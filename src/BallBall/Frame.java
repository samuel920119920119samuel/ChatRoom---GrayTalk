package BallBall;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class Frame  implements ActionListener{
	public Game game = new Game();
	public Home home = new Home();
	public talk talk = new talk();
	public select select = new select();
	public Gameover gameover = new Gameover();
	
	public JFrame frame = new JFrame();
	
	static int FHeight;
	static int FWidth;
	File sound1 = home.file;
	File sound5 = select.BGMselect;
	File sound6 = gameover.BGMgameover;
	
	Timer time= new Timer(5,this);
	
	public static boolean togameover=false;
	
	
	public Frame(){
		//frame.setBackground(Color.BLACK);
		//btn.setBounds(0,0,100,100);
		frame.setTitle("BrickALL");
		frame.setSize(568,1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setResizable(false);

		frame.addKeyListener(talk);
		frame.addMouseListener(talk);
		frame.add(home);
		time.start();
		
		FHeight = frame.getHeight();
		FWidth = frame.getWidth();
		//this.addKeyListener(this);
    }
	
	void hometotalk(){
		if(home.startclick==true){
			frame.remove(home);
			frame.add(talk);
			talk.next=1;
			talk.nextpage();
			frame.repaint();
			frame.revalidate();
			home.startclick=false;
			
			
		}
	}
	void talktohome(){
		if(talk.backclick==true){
			frame.remove(talk);
			frame.add(home);
			frame.repaint();
			frame.revalidate();
			talk.backclick=false;
		}
	}
	void talkskip(){
		if(talk.skip==true){
			frame.remove(talk);
			frame.add(select);
			frame.repaint();
			frame.revalidate();
			talk.skip=false;
		}
	}
	void selecttogame(){
		if(select.selectover==true){
			frame.remove(select);
			frame.add(game);
			frame.repaint();
			frame.revalidate();
			game.chooseball();
			game.repaint();
			game.revalidate();
			select.selectover=false;
		}
	}
	void gametogameover(){
		if(Game.gameover==true&&togameover==false){
			gameover = new Gameover();
			frame.remove(game);
			frame.add(gameover);
			frame.repaint();
			frame.revalidate();
			Game.gameover=false;
			togameover=true;
		}
	}
	
	/*void gameagian(){
		if(gameover.gameagain==true){
			frame.remove(gameover);
			frame.add(select);
			frame.repaint();
			frame.revalidate();
			gameover.GOBGM.stop();
			try {
				select.SBGM.init(sound5.toURL());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			select.SBGM.play();
			select.ballselect=0;
			//togameover=false;
			gameover.gameagain=false;
		}
	}*/
	
	void gameagain(){
		if(gameover.gameagain==true){
			frame.dispose();
			gameover.gameagain=false;
		}
	}

	public void actionPerformed(ActionEvent e) {
		hometotalk();
		talktohome();
		talkskip();
		selecttogame();
		gametogameover();
		gameagain();
		
	}

}
