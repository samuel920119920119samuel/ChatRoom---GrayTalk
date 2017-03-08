package BallBall;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import javafx.scene.shape.Circle;

public class Game extends JPanel implements ActionListener,MouseListener,MouseMotionListener{

	private Graphics back;
	private Image buffer ; //緩衝
	private Image block1 = new ImageIcon("block2.png").getImage();
	private Image block1bright = new ImageIcon("block2-bright.png").getImage();
	private static Image bubble = new ImageIcon("bubble2.png").getImage();
	private static ImageIcon ball1 = new ImageIcon("bubble2.png");
	private static ImageIcon ball2 = new ImageIcon("ball2.png");
	private static ImageIcon ball3 = new ImageIcon("ball3.png");
	private Image bg1 = new ImageIcon("bg1.png").getImage();
	private Image bg2 = new ImageIcon("bg2.png").getImage();
	private Image top = new ImageIcon("top.png").getImage();
    private ArrayList<Image> ball = new ArrayList<Image>();
    private ArrayList<Image> block = new ArrayList<Image>();
    private ArrayList<Integer> blockx = new ArrayList<Integer>();
    private ArrayList<Integer> blocky = new ArrayList<Integer>();
    private ArrayList<Integer> blockHP = new ArrayList<Integer>();
    private ArrayList<Double> bx = new ArrayList<Double>();
    private ArrayList<Double> by = new ArrayList<Double>();
    private ArrayList<Double> xball = new ArrayList<Double>();
    private ArrayList<Double> yball = new ArrayList<Double>();
    private ArrayList<Boolean> blockbright = new ArrayList<Boolean>();
    //private double s=-1.0;
    //private Integer sx=100,sy=100;
    private int blx,bly;
    private int ballcount=0;
    private int balltime=0;
    private int balltimecou=1;
    private double startX,startY;
    private double startXtimp,startYtimp;
    private boolean firstball=true; //是否為第一顆落下的球
    public boolean roundover=true; //回合是否結束
    private ArrayList<Boolean> stopball = new ArrayList<Boolean>(); //是否球已落下
    private int stopballcount=0;
    private ArrayList<Boolean> startball = new ArrayList<Boolean>();
    private boolean strb=false;
    private boolean moveblock=false;
    private boolean adb=false;
    private int bmax=0;
    
	private Timer timer = new Timer(5,this);
	public boolean startgame=true;
	
	private double mousex,mousey; //滑鼠座標位置
	private double movex,movey;
	private float[] dash={15,15};
	private BasicStroke stroke = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND,10,dash, 100);//虛線設置
	private float lineWidth = 3.0f;
	Random random = new Random();
	private int lineX=0,lineY=0;
	
	public static int score;
	public static String topscore;
	static boolean gameover=false;
	public boolean gameoverevent=false;
	
	boolean BGMdan = false;
	boolean BGMdanback = false;
	int BGMdanBlock=0;
	
	Game(){
		
		this.setBackground(Color.BLACK);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		initial();
		timer.start();
		
	}
	public static void chooseball(){
		if(select.ballselect==1){
			bubble =ball1.getImage();
		}
		if(select.ballselect==2){
			bubble =ball2.getImage();
		}
		if(select.ballselect==3){
			bubble =ball3.getImage();
		}
	}
	public void initial(){
		strb=false;
		moveblock=false;
		startgame=true;
		gameover=false;
		gameoverevent=false;
		BGMdan = false;
		BGMdanback = false;
		BGMdanBlock=0;
		roundover=true;
		firstball=true;
		stopballcount=0;
		
		
		startX=284-bubble.getWidth(null)/2;
		startY=820-bubble.getHeight(null);
		startXtimp=284-bubble.getWidth(null)/2;
		startYtimp=820-bubble.getHeight(null);
		
		
		score=1;
		int iad=random.nextInt(5);
		for(int i=0;i<=iad;i++){
			block.add(block1);
			blx=random.nextInt(7)*80;
			bly=180;
			while(true){
				for(int j=0;j<blockx.size();j++){
					if(blx==blockx.get(j)){
						blx=random.nextInt(7)*80;
					}
						
				}
				for(int j=0;j<blockx.size();j++){
					if(blx==blockx.get(j)){
						adb=true;
					}
				}
				if(adb==false){
					break;
				}
				adb=false;
			}
			blockx.add(blx);
			blocky.add(bly);
			blockHP.add(1);
			blockbright.add(false);
		}
		
		try{
			FileReader fr = new FileReader("top score.txt");
			BufferedReader br = new BufferedReader(fr);	
			topscore = br.readLine();
			br.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
		
	public void update(Graphics g){
		buffer = createImage(Frame.FWidth,Frame.FHeight);
		back = buffer.getGraphics();
		Graphics2D g2 = (Graphics2D)buffer.getGraphics();
		Graphics2D g3 = (Graphics2D)buffer.getGraphics();
		g2.setStroke(stroke);
		g3.setStroke(new BasicStroke(lineWidth));
		g3.setColor(Color.BLACK);
		if(BGMdanback==false){
			back.drawImage(bg1,0,0,null);
		}
		if(BGMdanback==true){
			back.drawImage(bg2,0,0,null);
		}
		back.drawImage(bubble, (int)startXtimp, (int)startYtimp, null);
		back.drawImage(top,0,0,null);
		
		
		back.setColor(Color.WHITE);
		back.setFont(new Font("AR DESTINE",Font.BOLD,50));
		if(score<10){
			back.drawString("0"+String.valueOf(score),252,65);
		}
		if(score>=10){
			back.drawString(String.valueOf(score),260,65);
		}
		back.setFont(new Font("AR DESTINE",Font.ITALIC,30));
		back.drawString("top",480,40);
		back.drawString(topscore,480,77);
		
		
		g3.drawLine(0,820,568,820);
		back.setFont(new Font("AR CENA",Font.BOLD,40));
		back.setColor(Color.BLACK);
		for(int j=0; j<block.size(); j++){
			if(blockbright.get(j)==true){
				back.drawImage(block1bright,blockx.get(j),blocky.get(j),null);
				blockbright.set(j, false);
				System.out.println("bright"+" "+j);
			}
			else{
				back.drawImage(block1,blockx.get(j),blocky.get(j),null);
			}
			back.drawString(String.valueOf(blockHP.get(j)), blockx.get(j)+block1.getWidth(null)/2-10, blocky.get(j)+block1.getHeight(null)/2+10);
		}
		
		
		for(int i=0 ; i<ball.size(); i++){
			back.drawImage(ball.get(i), xball.get(i).intValue(), yball.get(i).intValue(), null);
		}
		if(roundover==true||startgame==true){
			g2.drawLine((int)startXtimp+bubble.getWidth(null)/2, (int)startYtimp+bubble.getHeight(null)/2, lineX, lineY);
		}
		g.drawImage(buffer, 0, 0, this);
		
		
	}
	
	public void paint(Graphics g){
		update(g);
	}

	public void addball(){
		ball.add(bubble);
		bx.add(movex);
		by.add(movey);
		xball.add(startX);
		yball.add(startY);
		stopball.add(false);
		startball.add(true);
	}
	
	public void addblock(){
		block.add(block1);
		blx=random.nextInt(7)*80;
		bly=100;
		while(true){
			for(int i=0;i<blockx.size();i++){
				if(blx==blockx.get(i)&&bly==blocky.get(i)){
					blx=random.nextInt(7)*80;
				}
					
			}
			for(int i=0;i<blockx.size();i++){
				if(blx==blockx.get(i)&&bly==blocky.get(i)){
					adb=true;
				}
			}
			if(adb==false){
				break;
			}
			adb=false;
		}
		blockx.add(blx);
		blocky.add(bly);
		blockbright.add(false);
		if(ballcount==0){
			blockHP.add(1);
		}
		else{
			blockHP.add(ballcount+1);
		}
	}
	
	public void adfunction(){
		int ad=random.nextInt(5);
		for(int i=0;i<=ad;i++){
			addblock();
		}
	}
	
	public void moveball(){
		for(int i=0; i<ball.size(); i++ ){
			if(startball.get(i)==true){
				movex=5*(mousex-startX)/Math.sqrt(((mousex-startX)*(mousex-startX))+((mousey-startY)*(mousey-startY)));
				movey=5*(mousey-startY)/Math.sqrt(((mousex-startX)*(mousex-startX))+((mousey-startY)*(mousey-startY)));
				bx.set(i,movex);
				by.set(i,movey);
				
			}
			if(startball.get(i)==false&&yball.get(i)+bubble.getHeight(null)>820){
				if(firstball==true){
					if(xball.get(i)<=0){
						startXtimp=xball.get(i)+1;
					}
					if(xball.get(i) >=Frame.FWidth-bubble.getWidth(null)){
						startXtimp=xball.get(i)-1;
					}
					else{
						startXtimp=xball.get(i);
					}
					
					startYtimp=820-bubble.getHeight(null);
					firstball=false;
					
				}
				stopball.set(i,true);
			}
			
			if(xball.get(i) <= 0 || 
			   xball.get(i) >=Frame.FWidth-bubble.getWidth(null) ){
				bx.set(i, bx.get(i)*(-1));
				
			}
			if(yball.get(i) <= 100 ){
				by.set(i, by.get(i)*(-1));
				
			}
			/*if(yball.get(i) <= 0 || 
			   yball.get(i) >=Frame.frame.getHeight()-bubble.getHeight(null) ){
				by.set(i, by.get(i)*(-1));
			}*/
			for(int j=0; j<block.size(); j++){
				//碰撞右邊
				if(bx.get(i)<0 && xball.get(i)+bubble.getWidth(null)>blockx.get(j)+block1.getWidth(null) &&
				   xball.get(i)<=blockx.get(j)+block1.getWidth(null) && 
				   yball.get(i)<=blocky.get(j)+block1.getHeight(null) &&
				   yball.get(i)>=blocky.get(j)-bubble.getHeight(null)){
					bx.set(i, bx.get(i)*(-1));
					blockHP.set(j, blockHP.get(j)-1);
					blockbright.set(j, true);
					System.out.println("brightR");
					
					
				}
				//碰撞左邊
				if(bx.get(i)>0 && xball.get(i)<blockx.get(j) &&
				   xball.get(i)+bubble.getWidth(null)>=blockx.get(j) && 
				   yball.get(i)<=blocky.get(j)+block1.getHeight(null) &&
				   yball.get(i)>=blocky.get(j)-bubble.getHeight(null)){
					bx.set(i, bx.get(i)*(-1));
					blockHP.set(j, blockHP.get(j)-1);
					blockbright.set(j, true);
					System.out.println("brightL");
					
				}
				//碰撞下方
				if(by.get(i)<0 && yball.get(i)+bubble.getHeight(null)>blocky.get(j)+block1.getHeight(null) &&
				   yball.get(i)<=blocky.get(j)+block1.getHeight(null) &&
				   xball.get(i)<=blockx.get(j)+block1.getWidth(null) &&
				   xball.get(i)>=blockx.get(j)-bubble.getWidth(null)){
					by.set(i, by.get(i)*(-1));
					blockHP.set(j, blockHP.get(j)-1);
					blockbright.set(j, true);
					System.out.println("brightD");
				}
				//碰撞上方
				if(by.get(i)>0 && yball.get(i)<blocky.get(j) &&
				   yball.get(i)+bubble.getHeight(null)>=blocky.get(j) &&
				   xball.get(i)<=blockx.get(j)+block1.getWidth(null) &&
				   xball.get(i)>=blockx.get(j)-bubble.getWidth(null)){
					by.set(i, by.get(i)*(-1));
					blockHP.set(j, blockHP.get(j)-1);
					blockbright.set(j, true);
					System.out.println("brightU");
					
				}
			}
			if(stopball.get(i)==false){
				xball.set(i,bx.get(i)+xball.get(i));
				yball.set(i,by.get(i)+yball.get(i));
				
				startball.set(i,false);
				
			}
			else if(stopball.get(i)==true){
				if(xball.get(i)>startXtimp&&xball.get(i)-startXtimp>20){
				xball.set(i,xball.get(i)-5);
				}
				if(xball.get(i)<startXtimp&&startXtimp-xball.get(i)>20){
					xball.set(i,xball.get(i)+5);
				}
				if(xball.get(i)-startXtimp<20&&xball.get(i)-startXtimp>0){
					xball.set(i,startXtimp);
				}
				if(startXtimp-xball.get(i)<20&&startXtimp-xball.get(i)>0){
					xball.set(i,startXtimp);
				}
				else if(xball.get(i)==startXtimp){
					
				}
			}
			
		}
		
	}
	public void moveblock(){
		
		for(int i=0;i<block.size();i++){
			int b=1;
			blocky.set(i,blocky.get(i)+b);
			
			
		}
		bmax=bmax+1;
		if(bmax>=80){
			moveblock=false;
			bmax=0;
		}
	}
	public void startball(){
		/*for(int i=0; i<ball.size(); i++){
			if(Math.abs(mousex-startX)>=Math.abs(mousey-startY)){
				movex=(startX-mousex)/Math.abs((mousey-startY));
				movey=(mousey-startY)/(mousey-startY);
				bx.set(i,movex);
				by.set(i,movey);
			}
			else if(Math.abs(mousex-startX)<=Math.abs(mousey-startY)){
				movex=(startX-mousex)/(startX-mousex);
				movey=Math.abs((mousey-startY)/(startX-mousex));
				bx.set(i,movex);
				by.set(i, movey);
			}
			xball.set(i, xball.get(i)+bx.get(i));
			yball.set(i, yball.get(i)+by.get(i));
			
		}*/
		for(int i=0; i<ball.size(); i++){
			movex=5*(mousex-startX)/Math.sqrt(((mousex-startX)*(mousex-startX))+((mousey-startY)*(mousey-startY)));
			movey=5*(mousey-startY)/Math.sqrt(((mousex-startX)*(mousex-startX))+((mousey-startY)*(mousey-startY)));
			bx.set(i,movex);
			by.set(i,movey);
			xball.set(i, xball.get(i)+bx.get(i));
			yball.set(i, yball.get(i)+by.get(i));
		}
		
		strb=false;
	}
	
	public void removeball(){
		ball.clear();
		xball.clear();
		yball.clear();
		bx.clear();
		by.clear();
		stopball.clear();
		startball.clear();
		/*for(int i=0; i<ball.size(); i++){
			ball.remove(i);
			xball.remove(i);
			yball.remove(i);
			bx.remove(i);
			by.remove(i);
			stopball.remove(i);
			startball.remove(i);
		}*/
	}
	public void removeblock(){
		for(int i=0;i<block.size();i++){
			if(blockHP.get(i)<=0){
				block.remove(i);
				blockx.remove(i);
				blocky.remove(i);
				blockHP.remove(i);
				blockbright.remove(i);
			}
		}
	}
	
	public void testroundover(){
		if(roundover==false){
			for(int i=0; i<stopball.size(); i++){
				if(stopball.get(i)==true){
					stopballcount++;
				}
			}
			if(stopballcount==stopball.size()){
				roundover=true;
				removeball();
				adfunction();
				moveblock=true;
				score++;
				if(score>Integer.valueOf(topscore)){
					topscore=String.valueOf(score);
				}
			}
			stopballcount=0;
		}
		
	}
	public void danmusic(){
		if(block.size()>0){
			for(int i=0;i<block.size();i++){
				if(BGMdan==true){
					if(blocky.get(i)+block1.getHeight(null)<660){
						BGMdanBlock++;
					}
			
				}
			}
			if(BGMdanBlock==block.size()){
				BGMdan=false;
				BGMdanback=false;
			}
			BGMdanBlock=0;
		}	
	}
	public void testgameover(){
		for(int i=0;i<block.size();i++){
			if(blocky.get(i)+block1.getHeight(null)>=820){
				gameover=true;
				gameoverevent=true;
			}
		}
	}
	public void gameoverevent(){
		try{
			if(score>=Integer.valueOf(topscore)){
				FileWriter fw = new FileWriter("top score.txt");
				fw.write(topscore);
				//fw.flush();
				fw.close();
				gameoverevent=false;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		testroundover();
		testgameover();
		
		danmusic();
		
		if(gameoverevent==true){
			gameoverevent();
		}
		
		if(moveblock==true){
			moveblock();
		}
		moveball();
		removeblock();
		
		repaint();
		
		balltime++;
		if(balltimecou<ballcount){
			if(balltime%50==0){
				addball();
				balltimecou++;
				
			}
		}

	}

	public void mouseClicked(MouseEvent e) {
		if(roundover==true&&moveblock==false){
			if(e.getButton()==MouseEvent.BUTTON1){
				if(startgame==true){
					startgame=false;
				}
				ballcount++;
					
				mousex=e.getPoint().x;
				mousey=e.getPoint().y;
					
					//movex=(startX-mousex)/Math.sqrt(((mousex-startX)*(mousex-startX))+((mousey-startY)*(mousey-startY)));
					//movey=(mousey-startY)/Math.sqrt(((mousex-startX)*(mousex-startX))+((mousey-startY)*(mousey-startY)));
					
				startX=startXtimp;
				startY=startYtimp;
				//strb=true;
				firstball=true;
				balltime=0;
				balltimecou=1;
				addball();
				
			}
			roundover=false;
		
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
	public void mouseDragged(MouseEvent e) {

	}
	public void mouseMoved(MouseEvent e) {
		lineX=e.getPoint().x;
		lineY=e.getPoint().y;
	}
}

