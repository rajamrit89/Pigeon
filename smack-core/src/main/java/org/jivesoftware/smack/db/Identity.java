package org.jivesoftware.smack.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "identity",daoClass = IdentityDAO.class)
public class Identity {
	
	// unique id for identity
	@DatabaseField(id = true)
	private long iId;
	
	//
	@DatabaseField
	private int type;
	
	// e.g. mobile no or facebook id
	@DatabaseField(canBeNull = false)
	private String identifier; 
	
	//e.g.- online
	@DatabaseField
	private IdentityStatus status;
	
	//url of image of identity
	@DatabaseField
	private String image;
	
	// name of the identity
	@DatabaseField
	private String name;
	
	/*
	 *   this field tells whether you want to send with this identity whenever you create a chat
	 *    or you want to select each time
	 */
	@DatabaseField
	private boolean defaultIdentity;
	
	// whether this identity is blocked by user or not 
	@DatabaseField
	private boolean blocked;

	public long getiId() {
		return iId;
	}

	public void setiId(long iId) {
		this.iId = iId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public IdentityStatus getStatus() {
		return status;
	}

	public void setStatus(IdentityStatus status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isUnique() {
		return defaultIdentity;
	}

	public void setUnique(boolean unique) {
		this.defaultIdentity = unique;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	
}
