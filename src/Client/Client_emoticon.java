package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.UnsupportedEncodingException;

public class Client_emoticon extends Client_emoticon_GUI implements ActionListener, WindowListener{
	Client_emoticon(){
		frame.addWindowListener(this);
		
		//�C��r
		sticker1.addActionListener(this);
		sti1_but1.addActionListener(this);
		sti1_but2.addActionListener(this);
		sti1_but3.addActionListener(this);
		sti1_but4.addActionListener(this);
		sti1_but5.addActionListener(this);
		sti1_but6.addActionListener(this);
		sti1_but7.addActionListener(this);
		sti1_but8.addActionListener(this);
		sti1_but9.addActionListener(this);
		sti1_but10.addActionListener(this);
		sti1_but11.addActionListener(this);
		sti1_but12.addActionListener(this);
		sti1_but13.addActionListener(this);
		sti1_but14.addActionListener(this);
		sti1_but15.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = new String(e.getActionCommand().trim());
	
		/*
		 TF8F8
		String utf8String = null ;
		try {
			utf8String = new String(str.getBytes("MS950"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		*/
		
		//�I�F�W�誺���s�A��ܩҦ��K��
		if (e.getSource() == sticker1){
			scrollPane_sticker.setVisible(true);
			//System.out.println("rrrr");
		}
		
		//�N���I���K�ϩ���ܿ�J�ؤ�
		else{
			Client_room.input.setText(Client_room.input.getText()+str);
			System.out.println(str);
		}
		
	}


	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		//�Ϥp�u��������i�H�A�Q���}
		Client_room.emotionOpen = false;
	}


	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) {
		
	}



}
