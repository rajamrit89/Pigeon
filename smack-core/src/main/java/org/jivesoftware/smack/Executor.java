package org.jivesoftware.smack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.packet.Presence;

public class Executor {

	public static void main(String[] args) throws IOException {
		JabberSmackAPI connection = new JabberSmackAPI();
		try {
			connection.login("rajeev", "rajeev");
			Chat chat = null;
			chat = connection.getChat("raj@amritr-dt/Smack");
			Presence presence = new Presence(Presence.Type.available);
			presence.setStatus("What's up Raj?");
			connection.sendPacket(presence);
			connection.displayBuddyList();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			connection.createEntry("raj@amritr-dt/Smack", "rajwa");
			String s = br.readLine();
			while(!s.equals("bye")){
				try {
					chat.sendMessage(s);
				} catch (NotConnectedException e) {
					System.out.println("I think, it is not connected, is it");
					e.printStackTrace();
				}
				System.out.println("Rajeev : ");
				s = br.readLine();
			}
			connection.disconnect();
			
		} catch (XMPPException e) {
			e.printStackTrace();
		}
//		Executor ex = new Executor();
//		Thread raj = ex.newThread(new JabberSmackAPI(), "raj","raj","rajeev@amritr-dt/Smack");
//		Thread rajeev = ex.newThread(new JabberSmackAPI(), "rajeev","rajeev","raj@amritr-dt/Smack");
//		raj.start();
//		rajeev.start();
	}
	
	
	
//	private  Thread newThread(final JabberSmackAPI api,final String user,final String pass,final String friend){
//		Thread t = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					api.login(user, pass);
//				} catch (XMPPException e) {
//					System.out.println("there is some problem with "+user);
//					e.printStackTrace();
//				}
//				Presence presence = new Presence(Presence.Type.available);
//				presence.setStatus("What's up everyone?");
//				api.sendPacket(presence);
//				api.displayBuddyList();
////				if(api.getChat() == null){
////					api.setChat(api.getChat()) ;
////				}
//				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//				String s = null;
////				if(api.getChat()== null){
////					
////				}
//				Chat chat = null;
//				try {
//					chat = api.getChat(friend);
//				} catch (XMPPException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				try {
//					s = br.readLine();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				while(!s.equals("bye")){
//					try {
//						chat.sendMessage(s);
//					} catch (NotConnectedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					try {
//						System.out.println(user+ " :");
//						s = br.readLine();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//				api.disconnect();
//				
//			}
//		});
//		return t;
//	}
}
