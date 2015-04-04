package org.jivesoftware.smack;

import java.util.*;
import java.io.*;

import org.jivesoftware.smack.SmackException.NoResponseException;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.SmackException.NotLoggedInException;
import org.jivesoftware.smack.XMPPException.XMPPErrorException;
import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatManagerListener;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.filter.AndFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.filter.PacketTypeFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.RosterEntry;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
 
public class JabberSmackAPI implements ChatMessageListener {

	XMPPConnection connection;
//	static Chat chat = null;
//	static ChatManager chatManager = null;

	public void login(String userName, String password) throws XMPPException {
		connection = new XMPPTCPConnection(XMPPTCPConnectionConfiguration.builder()
			     .setServiceName("amritr-dt").setHost("localhost").build());
		try {
			((AbstractXMPPConnection) connection).connect();
		} catch (SmackException e) {
			System.out.println("There is some problem with smack");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ahh, i think you have encounter some I/O problem, or may be we are not able to connect properly :)");
			e.printStackTrace();
		}
		try {
			((AbstractXMPPConnection) connection).login(userName, password);
		} catch (SmackException e) {
			System.out.println("There is some problem login");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There is some problem login with io");
			e.printStackTrace();
		}
//		Thread t = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				listeningForMessages();
//			}
//		});
//		t.start();
	}

	public XMPPConnection getConnection(){
		return connection;
	}
	
	public Chat getChat(String to) throws XMPPException {
		ChatManager chatManager = ChatManager.getInstanceFor(connection);
		chatManager.addChatListener(new ChatManagerListener() {
			
			@Override
			public void chatCreated(Chat chat, boolean createdLocally) {
				chat.addMessageListener(new ChatMessageListener(){

					@Override
					public void processMessage(Chat chat, Message message) {
						if (message.getType() == Message.Type.chat)
							System.out.println(chat.getParticipant() + " says: "
									+ message.getBody());
					}
					
				});
			}
		});
		return chatManager.createChat(to, this);
	}
	
	public void createEntry(String user,String name){
		Roster roster = Roster.getInstanceFor(connection);
		try {
			roster.createEntry(user, name, null);
		} catch (NotLoggedInException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMPPErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotConnectedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void displayBuddyList() {
		Roster roster = Roster.getInstanceFor(connection);
		Collection<RosterEntry> entries = roster.getEntries();

		System.out.println("\n\n" + entries.size() + " buddy(ies):");
		for (RosterEntry r : entries) {
			System.out.println(r.getUser());
		}
	}

	public void disconnect() {
		((AbstractXMPPConnection) connection).disconnect();
	}

	public void processMessage(Chat chat, Message message) {
		if (message.getType() == Message.Type.chat)
			System.out.println(chat.getParticipant() + " says: "
					+ message.getBody());
	}

//	public static void main(String args[]) throws XMPPException, IOException {
		// declare variables
//		JabberSmackAPI c = new JabberSmackAPI();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String msg;
//
//		// turn on the enhanced debugger
////		XMPPConnection.DEBUG_ENABLED = true;
//
//		// Enter your login information here
//		c.login("[B]username[/B]", "[B]password[/B]");
//
//		c.displayBuddyList();
//
//		System.out.println("-----");
//
//		System.out
//				.println("Who do you want to talk to? - Type contacts full email address:");
//		String talkTo = br.readLine();
//
//		System.out.println("-----");
//		System.out.println("All messages will be sent to " + talkTo);
//		System.out.println("Enter your message in the console:");
//		System.out.println("-----\n");
//
//		while (!(msg = br.readLine()).equals("bye")) {
//			c.sendMessage(msg, talkTo);
//		}
//
//		c.disconnect();
//		System.exit(0);
//	}
//
	public void sendPacket(Presence presence) {
		try {
			connection.sendPacket(presence);
		} catch (NotConnectedException e) {
			System.out.println("error while sending packet of persence");
			e.printStackTrace();
		}
	}
//	public Chat getChat(){
//		return chat;
//	}
//	public void setChat(Chat chat){
//		this.chat =chat;
//	}
	public void listeningForMessages() {
	    PacketFilter filter = new AndFilter(new PacketTypeFilter(Message.class));
	    PacketCollector collector = connection.createPacketCollector(filter);
	    while (true) {
	        Stanza stanza = collector.nextResult();
	        if (stanza instanceof Message) {
	            Message message = (Message) stanza;
	            if (message != null && message.getBody() != null)
	                System.out.println("Received message from "
	                        + stanza.getFrom() + " : "
	                        + (message != null ? message.getBody() : "NULL"));
	        }
	    }
	}


}


class MyMessageListener implements MessageListener {


	@Override
	public void processMessage(Message message) {
		String from = message.getFrom();
		String body = message.getBody();
		System.out.println(String.format("Received message '%1$s' from %2$s",
				body, from));
	}

}
