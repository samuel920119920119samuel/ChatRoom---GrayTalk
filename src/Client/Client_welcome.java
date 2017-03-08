package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;


public class Client_welcome extends Client_welcome_GUI implements ActionListener{
	public static String name, ip;
	 //建立Socket變數 
	public static Socket sock;
	public boolean connectSuccess;
	
	public Client_welcome(){
		super();
		sendButton.addActionListener(this);

	}
		
	//建立連線
	private void EstablishConnection(){
	
		try{
			//請求建立連線
			sock = new Socket(ip,8888);      
			//連線成功
			lb_state.setText("連線成功");
			System.out.println("client 連線成功");    	
			connectSuccess = true;
			
			//關閉視窗 開新視窗
			this.frame.dispose();
			Client_room room = new Client_room();
			room.frame.setVisible(true);
		}
		catch(IOException ex ){
			lb_state.setText("連線失敗");
			System.out.println("client 連線失敗");
			name = "";
			ip = "";
			connectSuccess = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String str=e.getActionCommand();   
		//按下設定
		if(str.equals("Chat !")){
			if(tp_id.getText().equals("")){
				lb_state.setText("聊天室怎麼能沒IP");
			}
			else if(tp_nickname.getText().equals("")){
				lb_state.setText("給個綽號吧");
			}
				
			else{
				//設定名字
				name = tp_nickname.getText();
				//設定IP
				ip  = tp_id.getText(); 
				//建立連線
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
