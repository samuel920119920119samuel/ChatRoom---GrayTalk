package Client;

import java.awt.EventQueue;

import com.alee.laf.WebLookAndFeel;
	
	//BallBall�M�׬�104502538¿�T�|���M��(80%�����~)�A�ڶ��~�Ӧo���C���P�ڪ���ѫǥ\��f�t
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
