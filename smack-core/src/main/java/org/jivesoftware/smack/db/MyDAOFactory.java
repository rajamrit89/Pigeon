package org.jivesoftware.smack.db;

import java.sql.SQLException;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class MyDAOFactory {
	private static final String DATABASE_NAME = "jdbc:sqlite:smack-core/src/main/resources/org.jivesoftware.smack.db/clientStorage";
	
	private static MyDAOFactory instance = null;
	
	private JdbcPooledConnectionSource connectionSource = null;
	
	private MessageDAO messageDAO = null;
	
	private ConversationDAO conversationDAO = null;
	
	private IdentityDAO identityDAO = null;
	
	public static MyDAOFactory getInstance(){
		if(instance == null){
			synchronized (MyDAOFactory.class) {
				if(instance == null){
					instance = new MyDAOFactory();
				}
			}
		}
		return instance;
	}
	/*
	 * Note: DAO creation and database table creation are bind together. This may not be good practice so if possible
	 * seprete these two.
	 * 
	 * Needs to refactor when used with jars, needs to create a class with DB create and upgrade 
	 */
	private MyDAOFactory(){
		try {
			connectionSource = new JdbcPooledConnectionSource(DATABASE_NAME);
			
			TableUtils.createTableIfNotExists(connectionSource, Message.class);
	    	
	    	TableUtils.createTableIfNotExists(connectionSource, Conversation.class);
	    	
	    	TableUtils.createTableIfNotExists(connectionSource, Identity.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public MessageDAO getMessageDAO(){
		
		try {
			messageDAO = DaoManager.createDao(connectionSource, Message.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageDAO;
	}
	
	public ConversationDAO getConversationDAO(){
		
		try {
			conversationDAO = DaoManager.createDao(connectionSource, Conversation.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conversationDAO;
	}
	
	public IdentityDAO getIdentityDAO(){
		
		try {
			identityDAO = DaoManager.createDao(connectionSource, Identity.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return identityDAO;
	}
}
