package org.jivesoftware.smack.db;

import java.util.Date;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "message",daoClass = MessageDAO.class)
public class Message {
	
	/*
	 * Every message belongs to a chatThread(may be called as "chat").
	 * If there is no chatThread then one will be created to accommodate the 
	 * message
	 */
	@DatabaseField
	private long chatThreadId;
	
	// unique id for one chatThread (alias :conversation, chat)
	@DatabaseField
	private long mId;
	
	// identity id of message i.e identity from which message has been sent
	@DatabaseField
	private long mIdentityId;
	
	// message as text if any
	@DatabaseField
	private String mText;
	
	// message type e.g photo, video,audio etc 
	@DatabaseField(dataType = DataType.ENUM_STRING)
	private MessageType type;
	
	// the URL of photo or video if any
	@DatabaseField
	private String attachment;
	
	// status of message whether it is send to server or not
	//TODO: may change to boolean
	@DatabaseField(dataType = DataType.ENUM_STRING)
	private MessageStatus status;
	
	@DatabaseField(dataType = DataType.DATE_STRING)
	private Date deliveryTime;
	
	@DatabaseField(dataType = DataType.DATE_STRING)
	private Date sentTime;
	
	public Date getSentTime() {
		return sentTime;
	}

	public void setSentTime(Date sentTime) {
		this.sentTime = sentTime;
	}

	public Date getSeenTime() {
		return seenTime;
	}

	public void setSeenTime(Date seenTime) {
		this.seenTime = seenTime;
	}

	@DatabaseField(dataType = DataType.DATE_STRING)
	private Date seenTime; 

	public long getChatThreadId() {
		return chatThreadId;
	}

	public void setChatThreadId(long chatThreadId) {
		this.chatThreadId = chatThreadId;
	}

	public long getmId() {
		return mId;
	}

	public void setmId(long mId) {
		this.mId = mId;
	}

	public long getmIdentityId() {
		return mIdentityId;
	}

	public void setmIdentityId(long mIdentityId) {
		this.mIdentityId = mIdentityId;
	}

	public String getmText() {
		return mText;
	}

	public void setmText(String mText) {
		this.mText = mText;
	}

	public MessageType getType() {
		return type;
	} 

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	
	
	
}
