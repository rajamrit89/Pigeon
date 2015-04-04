package org.jivesoftware.smack.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "conversation",daoClass = ConversationDAO.class)
public class Conversation {

	@DatabaseField(id = true)
	private long cId;
	
	@DatabaseField
	private long lastMessageId;
	
	
	@DatabaseField
	private boolean groupConversation;
	
	
	@DatabaseField
	private long groupOwnerId;
	
	
	@DatabaseField
	private String participants;
	
	@DatabaseField
	private long lastReadMessageId;


	public long getcId() {
		return cId;
	}


	public void setcId(long cId) {
		this.cId = cId;
	}


	public long getLastMessageId() {
		return lastMessageId;
	}


	public void setLastMessageId(long lastMessageId) {
		this.lastMessageId = lastMessageId;
	}


	public boolean isGroupConversation() {
		return groupConversation;
	}


	public void setGroupConversation(boolean groupConversation) {
		this.groupConversation = groupConversation;
	}


	public long getGroupOwnerId() {
		return groupOwnerId;
	}


	public void setGroupOwnerId(long groupOwnerId) {
		this.groupOwnerId = groupOwnerId;
	}


	public List<Long> getParticipants() {
		String [] identityString = participants.split(",");
		List<Long> identitys = new ArrayList<Long>();
		for(String str :identityString){
			identitys.add(Long.parseLong(str));
		}
		return identitys;
	}

	public void setParticipants(List<Long> participants) {
		Iterator<Long> itr = participants.iterator();
		StringBuilder str = new StringBuilder();
		while(itr.hasNext()){
			Long id = itr.next();
			str.append(id);
			str.append(",");
		}
		str.deleteCharAt(str.length()-1);
		this.participants = str.toString();
	}


	public long getLastReadMessageId() {
		return lastReadMessageId;
	}


	public void setLastReadMessageId(long lastReadMessageId) {
		this.lastReadMessageId = lastReadMessageId;
	}
	
	
	
}
