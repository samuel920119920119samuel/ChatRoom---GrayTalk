package Server;

	import java.io.*;
	import java.net.*;
	import java.util.*;
	
	public class Server{

		 Vector output;//output
		 
		 public static void main (String args[]){
		  new Server().go();     
		 }
		 //�إ߳s�u
		 public void go() {
			    output = new Vector();          
			    try{
				    //port:8888
				    ServerSocket serverSock = new ServerSocket(8888);  
				    while(true){
					    //���ݳs�u
					    Socket cSocket = serverSock.accept();    
					    //�إ�I/O ���oSocket����X��Ƭy
					    PrintStream writer = new PrintStream(cSocket.getOutputStream());
					       
					    System.out.println(writer); 
					    //����[�JVector
					    output.add(writer);         
					    //���A���D�����
					    Thread t = new Thread(new Process(cSocket)); 
					    t.start();           
					    //���o�s�u��ip       
					    System.out.println(cSocket.getLocalSocketAddress()+ "��"+ (t.activeCount()-1) + "�ӳs��"); 
				    } 
			    }catch(Exception ex){System.out.println("�s������");}
		 }
		 //�B�z�{��
		 public class Process implements Runnable{   
			BufferedReader reader;  
			Socket sock;            
			//����
			public Process(Socket cSocket)
			{
				try{
					sock = cSocket;
					//���oSocket��J��Ƭy
					InputStreamReader isReader = new InputStreamReader(sock.getInputStream()); 
					reader = new BufferedReader(isReader);
				}catch(Exception ex){
					System.out.println("�s������Process");
				} 
		    }
			//����
			public void run(){
				String message;
				try{
				     while ((message = reader.readLine())!=null){   
				     System.out.println("����"+message);
				     tellApiece(message);
				     }
				}catch(Exception ex){System.out.println("���@�ӳs�����}");}
			}
		  
			//�s��
			public void tellApiece(String message){
				//����iterator�i�H�s�����X�����������    
				Iterator it = output.iterator();   
				while(it.hasNext()){          
				    try{
					    PrintStream writer = (PrintStream) it.next();  
					    writer.println(message); 
					    writer.flush();           
				    }
				    catch(Exception ex){
				    	System.out.println("�s������Process");
				    }
				}
			}
		 } 
	}

