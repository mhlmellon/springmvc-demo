package com.mellon.platform.privilege;

import java.io.Serializable;
import java.util.Date;

/**
 * All the VO classes must implements the AbstractVO class
 *
 * @author mellon
 * @version 1.0
 */
public abstract class AbstractVO implements Serializable{

	private Long id;

	private Long lastUpdateBy;

	private String lastUpdateName;

    private Date lastUpdateTime;

    private Long createBy;

    private String createName;

    private Date createTime;

    /**
     * Returns a string representation of the object.
     *
     * @return  a string representation of the object.
     */
    public abstract String toString();

    public abstract String validWhenAdd();

    public abstract String validWhenDelete();

    public abstract String validWhenUpdate();

    private Long version = 0L;

	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * @return the lastUpdateBy
	 */
	public Long getLastUpdateBy() {
		return lastUpdateBy;
	}

	/**
	 * @param lastUpdateBy the lastUpdateBy to set
	 */
	public void setLastUpdateBy(Long lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the lastUpdateName
	 */
	public String getLastUpdateName() {
		return lastUpdateName;
	}

	/**
	 * @param lastUpdateName the lastUpdateName to set
	 */
	public void setLastUpdateName(String lastUpdateName) {
		this.lastUpdateName = lastUpdateName;
	}

	/**
	 * @return the lastUpdateTime
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime the lastUpdateTime to set
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return the createBy
	 */
	public Long getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return the createName
	 */
	public String getCreateName() {
		return createName;
	}

	/**
	 * @param createName the createName to set
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
