package soket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class pincipalwebsoket {
	
	 @OnOpen
	    public void onOpen(Session session){
	        System.out.println(session.getId() + " has opened a connection"); 
	        try {
	        	
	        	
	        	session.getBasicRemote().sendText("Connection Established");
	        	
	        
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	 
	 @OnMessage
	    public void onMessage(String message, Session session){
	        System.out.println("Message from " + session.getId() + ": " + message);
	        try {
	            session.getBasicRemote().sendText(message);
	            
	            for (int i = 0; i <10; i++) {
	        		if(session==null||!session.isOpen()){
	        			break;
	        		}
	        		Thread.sleep(1000);
	        		session.getBasicRemote().sendText("Enviando despues de la conexión" + i);
	        		System.out.println("Enviando despues de la conexión" + i);
	        		
	        		
				}
	            
	        } catch (IOException | InterruptedException ex) {
	            ex.printStackTrace();
	        }
	    }
	
	 @OnClose
	    public void onClose(Session session){
	        System.out.println("Session " +session.getId()+" has ended");
	        try {
				session.close();
			} catch (IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}
	    }
	
	
	

}
