package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;


public class Client_welcome extends Client_welcome_GUI implements ActionListener{
	public static String name, ip;
	 //�إ�Socket�ܼ� 
	public static Socket sock;
	public boolean connectSuccess;
	
	public Client_welcome(){
		super();
		sendButton.addActionListener(this);

	}
		
	//�إ߳s�u
	private void EstablishConnection(){
	
		try{
			//�ШD�إ߳s�u
			sock = new Socket(ip,8888);      
			//�s�u���\
			lb_state.setText("�s�u���\");
			System.out.println("client �s�u���\");    	
			connectSuccess = true;
			
			//�������� �}�s����
			this.frame.dispose();
			Client_room room = new Client_room();
			room.frame.setVisible(true);
		}
		catch(IOException ex ){
			lb_state.setText("�s�u����");
			System.out.println("client �s�u����");
			name = "";
			ip = "";
			connectSuccess = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String str=e.getActionCommand();   
		//���U�]�w
		if(str.equals("Chat !")){
			if(tp_id.getText().equals("")){
				lb_state.setText("��ѫǫ���SIP");
			}
			else if(tp_nickname.getText().equals("")){
				lb_state.setText("���Ӻ︹�a");
			}
				
			else{
				//�]�w�W�r
				name = tp_nickname.getText();
				//�]�wIP
				ip  = tp_id.getText(); 
				//�إ߳s�u
				EstablishConnection();
			}
		
		}
		
		/*
		if(e.getSource()==IconTimer){
			System.out.println(alpha);
			SloganAlpha.setAlpha(alpha);
			SloganAlpha.repaint();
			alpha += 0.005;
			if(alpha >= 1)	IconTimer.stop();
		}	
		*/
	}
}
