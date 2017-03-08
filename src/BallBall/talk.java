package BallBall;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class talk extends JPanel implements ActionListener,MouseListener,KeyListener{
	private ImageIcon bet1 =new ImageIcon("bet1.png");
	private ImageIcon bet2 =new ImageIcon("bet2.png");
	private ImageIcon bet3 =new ImageIcon("bet3.png");
	private ImageIcon bet4 =new ImageIcon("bet4.png");
	private ImageIcon bet5 =new ImageIcon("bet5.png");
	private ImageIcon bet6 =new ImageIcon("bet6.png");
	private ImageIcon bet7 =new ImageIcon("bet7.png");
	private ImageIcon ttk =new ImageIcon("talk.png");
	private ImageIcon back =new ImageIcon("back.png");
	private ImageIcon backbright =new ImageIcon("backBright.png");
	private int keyboardInputCode;
	public boolean backclick = false;
	public boolean skip = false;
	public int next = 1;
	
	JLabel be1 = new JLabel();
	JLabel talkL = new JLabel();
	JLabel backL = new JLabel();
	JLabel talkword = new JLabel();
	JLabel skipword= new JLabel();
	JLabel clickword= new JLabel();
	
	talk(){
		
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.setSize(568,1000);
		this.requestFocus();
		//this.addKeyListener(this);
		
		skipword.setForeground(Color.WHITE);
		skipword.setBounds(30, 5, 200, 50);
		skipword.setFont(new Font("Agency FB",Font.BOLD,30));
		skipword.setText("Enter to Skip");
		this.add(skipword);
		
		clickword.setForeground(Color.WHITE);
		clickword.setBounds(70, 900, 500, 50);
		clickword.setFont(new Font("Agency FB",Font.BOLD,30));
		clickword.setText("Left-click to next                   Right-click to back");
		this.add(clickword);
		
		talkword.setBounds(55, 600, 450, 300);
		talkword.setFont(new Font("微軟正黑體",Font.BOLD,25));
		talkword.setText("醒醒啊，快醒醒啊勇者！！");
		this.add(talkword);
		
		talkL.setIcon(ttk);
		talkL.setBounds(12,650,ttk.getIconWidth(), ttk.getIconHeight());
		this.add(talkL);
		
		be1.setIcon(bet1);
		be1.setBounds(50, 300, bet1.getIconWidth(), bet1.getIconHeight());
		this.add(be1);
		
		backL.setIcon(back);
		backL.setBounds(462,10,back.getIconWidth(),back.getIconHeight());
		backL.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				backclick=true;
			}
			public void mouseEntered(MouseEvent e){
				backL.setIcon(backbright);
				
			}
			public void mouseExited(MouseEvent e) {
				backL.setIcon(back);
			}
		});
		this.add(backL);
		
		
	}
	
	public void nextpage(){
		if(next==1){
			be1.setIcon(bet1);
			talkword.setText("醒醒啊，快醒醒啊勇者！！");
		}
		if(next==2){
			be1.setIcon(bet1);
			talkword.setText("太好了您終於醒了，我們一直在等待您呢！");
		}
		if(next==3){
			be1.setIcon(bet3);
			talkword.setText("<html>我們的國家受到了鄰國的侵略，而變成了現在殘破的模樣...<html>");
		}
		if(next==4){
			be1.setIcon(bet3);
			talkword.setText("<html>所以我需要勇者您的幫忙，來打破鄰國所設下的魔法機關。<html>");
		}
		if(next==5){
			be1.setIcon(bet1);
			talkword.setText("<html>甚麼？你問我是誰？<html>");
		}
		if(next==6){
			be1.setIcon(bet5);
			talkword.setText("<html>我可是大名鼎鼎的守護龍，是這國家偉大的神哦！<html>");
		}
		if(next==7){
			be1.setIcon(bet3);
			talkword.setText("<html>但是因為國力衰落，我也因此失去了魔力，才變成了現在這副嬌小的模樣...<html>");
		}
		if(next==8){
			be1.setIcon(bet1);
			talkword.setText("<html>所以才非常需要勇者您的幫忙啊，沒有你可不行！<html>");
		}
		if(next==9){
			be1.setBounds(50, 300, bet1.getIconWidth(), bet1.getIconHeight());
			be1.setIcon(bet1);
			talkword.setText("<html>所以才非常需要勇者您的幫忙啊，沒有你可不行！<html>");
		}
		if(next==10){
			be1.setBounds(90, 300, bet1.getIconWidth(), bet1.getIconHeight());
			be1.setIcon(bet2);
			talkword.setText("<html>甚麼你願意幫助我們？真是太好了勇者謝謝你！<html>");
		}
		if(next==11){
			be1.setBounds(90, 300, bet1.getIconWidth(), bet1.getIconHeight());
			be1.setIcon(bet2);
			talkword.setText("<html>為了感謝你我將給你強大的魔法道具！等等就挑一個你喜歡的吧！<html>");
		}
		if(next==12){
			be1.setBounds(50, 300, bet1.getIconWidth(), bet1.getIconHeight());
			be1.setIcon(bet7);
			talkword.setText("<html>那麼事不宜遲，我們趕快出發吧！<html>");
		}
		if(next==13){
			skip=true;
			next=0;
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1){
			next++;
		}
		if(e.getButton()==MouseEvent.BUTTON3){
			if(next>1){
				next--;
			}
		}
		nextpage();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		
		
	}
	public void keyPressed(KeyEvent e) {
		keyboardInputCode = e.getKeyCode();
		System.out.println("hi");
		
		if(keyboardInputCode==KeyEvent.VK_ENTER){
			skip=true;
		}
		if(keyboardInputCode==KeyEvent.VK_SPACE){
		}
	}
	public void keyReleased(KeyEvent e) {
	}

}
