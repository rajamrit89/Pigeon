package org.jivesoftware.smack.db;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

public class ConversationDAO extends BaseDaoImpl<Conversation, String>{

	/**
	 * It is forbidden to use this constructor directly.
	 * As it is used by ormlite, visiblity of this method can not be changed to "private" 
	 */
	public ConversationDAO(ConnectionSource connectionSource)
			throws SQLException {
		super(connectionSource ,Conversation.class);
		// TODO Auto-generated constructor stub
	}

}
