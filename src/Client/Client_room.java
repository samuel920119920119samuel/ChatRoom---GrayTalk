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
	//建立I/O資料流//取得Socket的輸入資料流
	InputStreamReader streamReader =  new InputStreamReader(Client_welcome.sock.getInputStream());  
	//放入暫存區
	BufferedReader reader = new BufferedReader(streamReader);
	//取得Socket的輸出資料流
	PrintStream writer = new PrintStream(Client_welcome.sock.getOutputStream());
	boolean self;
	//計算狀態列顯示時間
	Timer stateTimer = new Timer(1000, this); 
	int time = 0;
	
	Client_room() throws IOException{
		
		super();
		
		//提示是否關閉聊天室
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
	
	//接收資料
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
		
		//按下enter傳送字句
		if(keyboardInputCode == KeyEvent.VK_ENTER) {
			//輸入不得為空白
			if(!input.getText().equals("")){
				try{
					//送出資料
					System.out.println(input.getText());
					writer.println((Client_welcome.name+" : "+input.getText()));
					//刷新該串流的緩衝。
					writer.flush();
					self = true;
				}catch(Exception ex ){
					System.out.println("送出資料失敗");
				}
				//清完輸入欄位
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
	
	//繼承遊戲，增加關閉與顯示得分功能
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
			//最低8分，得分顯示在聊天室
			if(BallBall.Game.score > 7){
				System.out.println("hi");
				writer.println(Client_welcome.name + "在BrickALL中獲得了 " + BallBall.Game.score + " 分。");
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
		
		//表情符號
		if(e.getSource()==emoticon && emotionOpen == false){
			Client_emoticon emotion = new Client_emoticon();
			emotion.frame.setVisible(true);
			emotionOpen = true;
		}
		
		//遊戲
		if( e.getSource()==game && gameOpen == false ){
			new HerGame();
			gameOpen = true;
			System.out.println(gameOpen);
		} 
		
		//歷史紀錄儲存
		if( e.getSource()==save ){
			saveFileAs();                        
		} 
		
		//歷史紀錄儲存成功/失敗顯示列
		if(e.getSource()==stateTimer){
			time++;
			System.out.println(time);
			//三秒後狀態列消失
			if(time >3){
				 stateTimer.stop();
				 state.setText("");
			 }
		}
		
	}
	
	//另存新檔
	private void saveFileAs() {
		JFileChooser fileChooser = new JFileChooser();
		// 顯示檔案對話方塊
		int option = fileChooser.showDialog(null, null);
		// 如果確認選取檔案
		if(option == JFileChooser.APPROVE_OPTION) {
			// 取得選擇的檔案
			File file = fileChooser.getSelectedFile();
			try {
				// 建立檔案
				 file.createNewFile();
				// 進行檔案儲存
				 FileWriter f = new FileWriter(file);     
				 f.write(output.getText());      
				 f.close();     
				 state.setText("歷史紀錄已保存");
				 stateTimer.start();
			}
			catch(IOException e) {
				state.setText("紀錄儲存失敗");
				stateTimer.start();
			}
		}
	}

}


	
		
	    

