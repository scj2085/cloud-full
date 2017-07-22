package com.cloud.provider.domain;

import java.io.Serializable;

/**
 * 台历表
 * @author shichangjian
 *
 */
public class Schedule implements Serializable {
	
	private static final long serialVersionUID = 4172873098418161091L;
	
	private long id;
	private Long parentId;		//父级
	private Long typeId;		//类型id
	private String name;		//台历名
	private String des;			//描述
	private byte level;			//层级
	private long ownerId;		//创建人id
	private String ownerName;	//创建人
	private long cid;			//公司id
	private long ctime;			//创建时间
	private long utime;			//更新时间
	private boolean deleted;	//是否删除
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public byte getLevel() {
		return level;
	}
	public void setLevel(byte level) {
		this.level = level;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public long getCtime() {
		return ctime;
	}
	public void setCtime(long ctime) {
		this.ctime = ctime;
	}
	public long getUtime() {
		return utime;
	}
	public void setUtime(long utime) {
		this.utime = utime;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	
	 
	
	
	
	

}
