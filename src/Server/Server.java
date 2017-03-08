package Server;

	import java.io.*;
	import java.net.*;
	import java.util.*;
	
	public class Server{

		 Vector output;//output
		 
		 public static void main (String args[]){
		  new Server().go();     
		 }
		 //建立連線
		 public void go() {
			    output = new Vector();          
			    try{
				    //port:8888
				    ServerSocket serverSock = new ServerSocket(8888);  
				    while(true){
					    //等待連線
					    Socket cSocket = serverSock.accept();    
					    //建立I/O 取得Socket的輸出資料流
					    PrintStream writer = new PrintStream(cSocket.getOutputStream());
					       
					    System.out.println(writer); 
					    //元件加入Vector
					    output.add(writer);         
					    //伺服器主執行緒
					    Thread t = new Thread(new Process(cSocket)); 
					    t.start();           
					    //取得連線的ip       
					    System.out.println(cSocket.getLocalSocketAddress()+ "有"+ (t.activeCount()-1) + "個連接"); 
				    } 
			    }catch(Exception ex){System.out.println("連接失敗");}
		 }
		 //處理程序
		 public class Process implements Runnable{   
			BufferedReader reader;  
			Socket sock;            
			//接收
			public Process(Socket cSocket)
			{
				try{
					sock = cSocket;
					//取得Socket輸入資料流
					InputStreamReader isReader = new InputStreamReader(sock.getInputStream()); 
					reader = new BufferedReader(isReader);
				}catch(Exception ex){
					System.out.println("連接失敗Process");
				} 
		    }
			//執行
			public void run(){
				String message;
				try{
				     while ((message = reader.readLine())!=null){   
				     System.out.println("收到"+message);
				     tellApiece(message);
				     }
				}catch(Exception ex){System.out.println("有一個連接離開");}
			}
		  
			//廣播
			public void tellApiece(String message){
				//產生iterator可以存取集合內的元素資料    
				Iterator it = output.iterator();   
				while(it.hasNext()){          
				    try{
					    PrintStream writer = (PrintStream) it.next();  
					    writer.println(message); 
					    writer.flush();           
				    }
				    catch(Exception ex){
				    	System.out.println("連接失敗Process");
				    }
				}
			}
		 } 
	}

