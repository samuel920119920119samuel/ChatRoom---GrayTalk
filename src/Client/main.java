package Client;

import java.awt.EventQueue;

import com.alee.laf.WebLookAndFeel;
	
	//BallBall專案為104502538聶偲帆的專案(80%完成品)，我僅繼承她的遊戲與我的聊天室功能搭配
	public class main {
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						 WebLookAndFeel.install();
						 Client_welcome welcome = new Client_welcome();
						 welcome.frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
						
				}
				
			}); 
		
		}
	}
