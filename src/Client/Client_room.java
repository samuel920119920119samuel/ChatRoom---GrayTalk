package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.Timer;

import java.io.File;

import BallBall.*;
import javafx.scene.media.AudioClip;

public class Client_room extends Client_room_GUI implements KeyListener, ActionListener{
	public static boolean emotionOpen = false , gameOpen= false;
	//�إ�I/O��Ƭy//���oSocket����J��Ƭy
	InputStreamReader streamReader =  new InputStreamReader(Client_welcome.sock.getInputStream());  
	//��J�Ȧs��
	BufferedReader reader = new BufferedReader(streamReader);
	//���oSocket����X��Ƭy
	PrintStream writer = new PrintStream(Client_welcome.sock.getOutputStream());
	boolean self;
	//�p�⪬�A�C��ܮɶ�
	Timer stateTimer = new Timer(1000, this); 
	int time = 0;
	
	Client_room() throws IOException{
		
		super();
		
		//���ܬO�_������ѫ�
		frame.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        int result=JOptionPane.showConfirmDialog(frame,
		                   "You won't keep the chat log if you leave",
		                   "" ,
		                   JOptionPane.YES_NO_OPTION,
		                   JOptionPane.WARNING_MESSAGE);
		        if (result==JOptionPane.YES_OPTION) {System.exit(0);}
		        }    
		});
		   
		input.addKeyListener(this);
		emoticon.addActionListener(this);
		save.addActionListener(this);
		readerThread.start();
		chatName.setText("Hi! " + Client_welcome.name);
		chatIP.setText("room : " + Client_welcome.ip);
		
	}
	
	//�������
	Thread readerThread = new Thread(new Runnable() {
		@Override
		public void run() {
				String message;
				try{
					while ((message = reader.readLine()) != null){
							Client_room.output.append(message+'\n');
							output.setCaretPosition(output.getDocument().getLength());
					}
			
				}catch(Exception ex ){ex.printStackTrace();}	
		}		
	}); 

	@Override
	public void keyPressed(KeyEvent arg0) {
		int keyboardInputCode = arg0.getKeyCode();
		
		//���Uenter�ǰe�r�y
		if(keyboardInputCode == KeyEvent.VK_ENTER) {
			//��J���o���ť�
			if(!input.getText().equals("")){
				try{
					//�e�X���
					System.out.println(input.getText());
					writer.println((Client_welcome.name+" : "+input.getText()));
					//��s�Ӧ�y���w�ġC
					writer.flush();
					self = true;
				}catch(Exception ex ){
					System.out.println("�e�X��ƥ���");
				}
				//�M����J���
				input.setText("");        
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//�~�ӹC���A�W�[�����P��ܱo���\��
	class HerGame extends BallBall.Frame implements WindowListener{

		HerGame() {
			super();
			frame.addWindowListener(this);
			
			// TODO Auto-generated constructor stub
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
			//�̧C8���A�o����ܦb��ѫ�
			if(BallBall.Game.score > 7){
				System.out.println("hi");
				writer.println(Client_welcome.name + "�bBrickALL����o�F " + BallBall.Game.score + " ���C");
				writer.flush();
			}
			gameOpen = false;
			
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
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//���Ÿ�
		if(e.getSource()==emoticon && emotionOpen == false){
			Client_emoticon emotion = new Client_emoticon();
			emotion.frame.setVisible(true);
			emotionOpen = true;
		}
		
		//�C��
		if( e.getSource()==game && gameOpen == false ){
			new HerGame();
			gameOpen = true;
			System.out.println(gameOpen);
		} 
		
		//���v�����x�s
		if( e.getSource()==save ){
			saveFileAs();                        
		} 
		
		//���v�����x�s���\/������ܦC
		if(e.getSource()==stateTimer){
			time++;
			System.out.println(time);
			//�T��᪬�A�C����
			if(time >3){
				 stateTimer.stop();
				 state.setText("");
			 }
		}
		
	}
	
	//�t�s�s��
	private void saveFileAs() {
		JFileChooser fileChooser = new JFileChooser();
		// ����ɮ׹�ܤ��
		int option = fileChooser.showDialog(null, null);
		// �p�G�T�{����ɮ�
		if(option == JFileChooser.APPROVE_OPTION) {
			// ���o��ܪ��ɮ�
			File file = fileChooser.getSelectedFile();
			try {
				// �إ��ɮ�
				 file.createNewFile();
				// �i���ɮ��x�s
				 FileWriter f = new FileWriter(file);     
				 f.write(output.getText());      
				 f.close();     
				 state.setText("���v�����w�O�s");
				 stateTimer.start();
			}
			catch(IOException e) {
				state.setText("�����x�s����");
				stateTimer.start();
			}
		}
	}

}


	
		
	    

