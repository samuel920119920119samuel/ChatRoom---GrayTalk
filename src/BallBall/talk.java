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
		talkword.setFont(new Font("�L�n������",Font.BOLD,25));
		talkword.setText("�����ڡA�ֿ����ګi�̡I�I");
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
			talkword.setText("�����ڡA�ֿ����ګi�̡I�I");
		}
		if(next==2){
			be1.setIcon(bet1);
			talkword.setText("�Ӧn�F�z�ש���F�A�ڭ̤@���b���ݱz�O�I");
		}
		if(next==3){
			be1.setIcon(bet3);
			talkword.setText("<html>�ڭ̪���a����F�F�ꪺ�I���A���ܦ��F�{�b�ݯ}���Ҽ�...<html>");
		}
		if(next==4){
			be1.setIcon(bet3);
			talkword.setText("<html>�ҥH�ڻݭn�i�̱z�������A�ӥ��}�F��ҳ]�U���]�k�����C<html>");
		}
		if(next==5){
			be1.setIcon(bet1);
			talkword.setText("<html>�ƻ�H�A�ݧڬO�֡H<html>");
		}
		if(next==6){
			be1.setIcon(bet5);
			talkword.setText("<html>�ڥi�O�j�W�������u�@�s�A�O�o��a���j�����@�I<html>");
		}
		if(next==7){
			be1.setIcon(bet3);
			talkword.setText("<html>���O�]����O�I���A�ڤ]�]�����h�F�]�O�A�~�ܦ��F�{�b�o�Ƽb�p���Ҽ�...<html>");
		}
		if(next==8){
			be1.setIcon(bet1);
			talkword.setText("<html>�ҥH�~�D�`�ݭn�i�̱z�������ڡA�S���A�i����I<html>");
		}
		if(next==9){
			be1.setBounds(50, 300, bet1.getIconWidth(), bet1.getIconHeight());
			be1.setIcon(bet1);
			talkword.setText("<html>�ҥH�~�D�`�ݭn�i�̱z�������ڡA�S���A�i����I<html>");
		}
		if(next==10){
			be1.setBounds(90, 300, bet1.getIconWidth(), bet1.getIconHeight());
			be1.setIcon(bet2);
			talkword.setText("<html>�ƻ�A�@�N���U�ڭ̡H�u�O�Ӧn�F�i�����§A�I<html>");
		}
		if(next==11){
			be1.setBounds(90, 300, bet1.getIconWidth(), bet1.getIconHeight());
			be1.setIcon(bet2);
			talkword.setText("<html>���F�P�§A�ڱN���A�j�j���]�k�D��I�����N�D�@�ӧA���w���a�I<html>");
		}
		if(next==12){
			be1.setBounds(50, 300, bet1.getIconWidth(), bet1.getIconHeight());
			be1.setIcon(bet7);
			talkword.setText("<html>����Ƥ��y��A�ڭ̻��֥X�o�a�I<html>");
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
